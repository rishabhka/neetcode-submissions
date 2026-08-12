class Solution {
    int [] rank ;
    int [] parent ;
    public int findParent(int x)
    {
        if(x==parent[x]) return x ;
        else return findParent(parent[x]) ;
    }
    public boolean union(int p,int q)
    {
        int parP = findParent(p);
        int parQ= findParent(q);
        if(parP==parQ) return true;
        if(rank[parP]==rank[parQ] )
        rank[parP] ++ ;
        if(parent[parP]>parent[parQ])
        parent[parQ]=parent[parP] ;
        else
        parent[parP]=parent[parQ] ;
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length ;
        rank = new int[edges.length] ;
        parent = new int[edges.length] ;
        for(int i=0;i<n;i++)
        {
            rank[i] = 1;
            parent[ i] = i;
        }
        for(int i=0;i<edges.length;i++)
        {
            if(union(edges[i][0]-1,edges[i][1]-1)) return edges[i] ;
        }
        return new int[2] ;
    }
}
