class Solution {

        int [] rank ; int [] parent ;
        public int findParent(int x)
        {
            if(x==parent[x]) return x;
            else return findParent(parent[x]) ;
        }
        public boolean union(int a , int b)
        {
            int parA = findParent(a) ;
            int parB = findParent(b) ;
            if(parA==parB) return true;
            if(rank[parA]==rank[parB])
            {
                rank[parA]  ++ ;
            }
            if(rank[parA]>rank[parB])
                parent[parB] = parent[parA] ;
            else
                parent[parA] = parent[parB] ;

            return false;
        }

    public boolean validTree(int n, int[][] edges) {

        rank = new int[n] ;  parent = new int[n] ;
        for(int i=0;i<n;i++)
        {
            rank[i] = 1;
            parent[i] = i;
        }
        for(int i=0;i<edges.length;i++)
        {
           if( union(edges[i][0],edges[i][1])) return false;
        }
        parent[0] = findParent(0) ;
        for(int i=1;i<n;i++)
        {
            parent[i] = findParent(i) ;
            if(parent[i]!=parent[i-1] ) return false;
        }
        return true;
    }
}
