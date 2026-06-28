class Solution {
    public boolean validTree(int n, int[][] edges) {
            if(edges.length>=n)
            return false;

            class UnionFind
            {
                public int [] rank ;
                public int [] parent ;
                UnionFind(int n)
                {
                    rank = new int[n];
                    parent = new int[n];
                    for(int i=0;i<n;i++)
                    {
                        rank[i] = 1;
                        parent[i] = i;
                    }
                }
                public int findParent(int child)
                {
                    int par = parent[child];
                    if(par==child)
                    return par;
                    else return findParent(par) ;
                }
                public boolean union(int u,int v)
                {
                    int x = findParent(u);
                    int y = findParent(v);
                    if(x==y) // cycle detected
                    return true ;
                    if(x!=y)
                    {
                        if(rank[x]>rank[y])
                        {
                        parent[y]= x ;
                        rank[x] ++ ;
                        }
                        else 
                        {
                        parent[x]= y ;
                        rank[y] ++ ;
                        }
                    }
                    return false;
                }
            }
            UnionFind uf = new UnionFind(n);
            for(int i=0;i<edges.length;i++)
            {
                if(uf.union(edges[i][0],edges[i][1]))
                return false;
            }
            for(int i=0;i<n-1;i++)
            {
                if(uf.findParent(i) != uf.findParent(i + 1))
                return false;
            }
            return true ;

    }
}
