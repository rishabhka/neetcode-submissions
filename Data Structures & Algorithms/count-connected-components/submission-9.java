class Solution {
    int [] parents;
    int [] rank ;
    public int find(int x)
    {
        if(x==parents[x])
        return x;
        else
        return find(parents[x]);
    }
    public boolean union(int x , int y)
    {
        int parX = find(x) ;
        int parY =  find(y) ;

        if(parX==parY) // cycle detection
        return false ;

        if(rank[parX]>=rank[parY])
        {
            parents[parY] = parX ;
            rank[parX] ++;
        }
        else if(rank[parX]<rank[parY])
        {
            parents[parX] = parY ;
            rank[parY] ++;
        }
        return true ;

    }
    public int countComponents(int n, int[][] edges) {
        parents = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)
        {
        parents[i] = i ;
        rank[i] =1 ;
        }
        int comp = n;
        for(int i=0;i<edges.length;i++)
        {
            if(union(edges[i][0],edges[i][1]))
            comp--;
        }
        return comp;
    }
}
