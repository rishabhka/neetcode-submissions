class Solution {
    class UnionFind
        {
            int [] parent ;
            int [] rank ;
            UnionFind(int n)
            {
                parent = new int[n];
                rank = new int[n];
                for(int i=0;i<n;i++)
                {
                    parent[i]= i;
                    rank[i] = 1;
                }
            }
            public int findParent(int x)
            {
                int y = parent[x];
                if(x!=y)
                return findParent(y) ;
                else return y ;
            }
            public boolean union(int u, int v)
            {
                int x = findParent(u) ;
                int y = findParent(v) ;

                if(x==y) return true ; // cycle

                if(rank[x]>rank[y])
                {
                    parent[y] = x;
                    rank[x] = rank[x] +1 ;
                }
                else
                {
                   parent[x] = y;
                   rank[y] = rank[y] +1 ; 
                }
                return false;
            }
        }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<edges.length;i++)
        {
            uf.union(edges[i][0],edges[i][1]);
        }
        for(int i=0;i<n;i++)
        {
            if(!set.contains(uf.findParent(i)))
            set.add(uf.findParent(i));
        }
        return set.size();

    }
}
