class Solution {
    class UnionFind
    {
        int [] parent ; int [] rank ; 
        UnionFind(int n) {this.parent = new int[n];
        this.rank = new int[n];
        }
        public int findParent(int a)
        {
            if(a==parent[a]) return parent[a];
            else return findParent(parent[a]) ;
        }
        public boolean add(int a,int b)
        {
            int parA =findParent( a);
            int parB =findParent( b);

            if(parA==parB) return true ;
            if(rank[parA]==rank[parB])
            {
            rank[parA]++ ;
            parent[parB] = parA ;
            }
            else if(rank[parA]>rank[parB])
            parent[parB] = parA ;
            else
            parent[parA] = parB ;
            return false;
        }
    }
    public int cost(int skip , int force ,int n , int [][] edges,Integer [] order )
    {
        UnionFind uf = new UnionFind(n);
        int dist =0 ;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            uf.parent[i] = i;
            uf.rank[i] = 1;
        }
        if(skip!=-1)
        {
            int count =0;
            for(int i=0;i<edges.length;i++)
            {
                if(order[i]==skip)
                continue ;
                else
                {
                if(!uf.add(edges[order[i]][0],edges[order[i]][1]))
                {
                dist = dist + edges[order[i]][2]; count ++;
                }
                }
            }
            if(count!=n-1)
            return Integer.MAX_VALUE;
            return dist ;
        }
        else
        {
            int count =1;
            uf.add(edges[force][0],edges[force][1]);
            dist = dist + edges[force][2];
            for(int i=0;i<edges.length;i++)
            {
                if(order[i]==force)
                continue ;
                else
                {
                if(!uf.add(edges[order[i]][0],edges[order[i]][1]))
                {
                dist = dist + edges[order[i]][2];
                count ++;
                }
                }
            }
            if(count!=n-1)
            return Integer.MAX_VALUE;
        return dist ;

        }
        
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        Integer [] order = new Integer [edges.length] ;
        for(int i=0;i<edges.length;i++)
        order[i] = i;
        Arrays.sort(order,(a,b)->
        {
            return Integer.compare(edges[a][2],edges[b][2]);
        });
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            uf.parent[i] = i;
            uf.rank[i] = 1;
        }   int dist =0;
        for(int i=0;i<edges.length;i++)
        {
           if(!uf.add(edges[order[i]][0],edges[order[i]][1]))
           dist = dist + edges[order[i]][2];
        }
        // int dist = uf.total_dist ;
        List<Integer> c = new ArrayList<>();
        List<Integer> nc = new ArrayList<>(); int skip = -1 ; int force = -1;
        for(int i=0;i<edges.length;i++)
        {
        int disX = cost(order[i],-1,n,edges,order) ; // skip 
        int disY = cost(-1,order[i],n,edges,order) ; // force
        if(disX>dist) c.add(order[i]);
        else if(disY==dist) nc.add(order[i]);
        else continue ;
        }
        res.add(c);
        res.add(nc);
        return res ;
    }
}