class Solution {
    int [] rank ;
    int [] parent ;
    public int findParent(int x )
    {
        if(x==parent[x]) return x ;
        else return findParent(parent[x]) ; 
    }
    public boolean union(int x , int y)
    {
        int parX = findParent(x);
        int parY = findParent(y);
        if(parX==parY) 
        return false ;
        if(rank[parX]==rank[parY])
        rank[parX] ++;
        if(rank[parX]>rank[parY])
        parent[parY] =parX ;
        else parent[parX] = parY ;
        return true;
    }
    public void initialiseRank(int n )
    {
        for(int i=0;i<n;i++)
        {
            rank[i] = 1 ;
            parent[i] = i ;
        }
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] ed) {
        List<List<Integer>> res = new ArrayList<>();
        int [][] edges = new int[ed.length][4];
        for(int i=0;i<ed.length;i++)
        {
            edges[i][0] = ed[i][0] ;
            edges[i][1] = ed[i][1] ;
            edges[i][2] = ed[i][2] ;
            edges[i][3] = i ;
        }
        Arrays.sort(edges,(a,b)->
        {
            return Integer.compare(a[2],b[2]) ;
        }) ;
        int minMSTwt = 0 ;
        rank  = new int[n] ;
        parent  = new int[n] ;
        initialiseRank(n) ;
        for(int i=0;i<edges.length;i++)
        {
            if(union(edges[i][0],edges[i][1])) minMSTwt = minMSTwt + edges[i][2] ;
        }
        // System.out.println(minMSTwt) ;
        List<Integer> ce = new ArrayList<>();
        List<Integer> nce = new ArrayList<>();
        for(int i=0;i<edges.length;i++)
        {
            int wt = 0;
            initialiseRank(n) ; int count =0 ;
            for(int j=0;j<edges.length;j++)
            {
                if(i!=j)
                if(union(edges[j][0],edges[j][1])) { wt = wt + edges[j][2] ;  count ++ ; }     
            }
            if(count<n-1||wt>minMSTwt) ce.add(edges[i][3]) ;
        }
        for(int i=0;i<edges.length;i++)
        {
            if (ce.contains(edges[i][3])) continue;
            initialiseRank(n) ;
            union(edges[i][0],edges[i][1]) ;
            int wt = edges[i][2]; int count = 1;
            for(int j=0;j<edges.length;j++)
            {
                if(i!=j)
                if(union(edges[j][0],edges[j][1])) { wt = wt + edges[j][2] ; count ++ ; }
            }
            if(count==n-1&&wt==minMSTwt) nce.add(edges[i][3]) ;
        }
        res.add(ce);
        res.add(nce) ;
        return res ;
    }
}