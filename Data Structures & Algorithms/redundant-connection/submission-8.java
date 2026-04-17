class Solution {
    int [] parent ;
    int [] rank ;
    public int findParent(int i)
    {
        if(i==parent[i])
        return i ;
        else return findParent(parent[i]);
    }
    public boolean union(int x, int y)
    {
        int parX = findParent(x);
        int parY = findParent(y);

        // System.out.println(parX+" "+parY);
        
        if(parX==parY) return true ;

        if(rank[parX]>=rank[parY])
        {
            parent[parY] = parX ;
            rank[parX] ++ ;
        }
        else if(rank[parX]<rank[parY])
        {
            parent[parX] = parY ;
            rank[parY] ++ ;
        }
        
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int vertex = edges.length;

        int [] result = new int [2] ;
        parent =new int [vertex+1] ;
        rank=new int [vertex+1] ;


        for(int i=0;i<=vertex;i++)
        parent[i] = i;
        

        for(int i=0;i<vertex;i++)
        {
            if(union(edges[i][0],edges[i][1]))
            {
                result[0] = edges[i][0];
                result[1] = edges[i][1] ;
            }
            
        }
        
        return result ;


    }
}
