class Solution {
    int [] parent ;
    int [] rank ;
    public int find(int x)
    {
        if(x==parent[x]) return x;
        else
        return find(parent[x]);
    }
    public boolean union(int x , int y)
    {
        int parX= find(x);
        int parY= find(y);
        if(parX==parY)
        return true;
        if(rank[parX]>=rank[parY])
        {
            parent[parY] = parX;
            rank[parX] ++;
        }
        else
        {
          parent[parX] = parY;
          rank[parY] ++;  
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length];
        rank = new int[edges.length];
        for(int i=0;i<edges.length;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<edges.length;i++)
        {
            if(union(edges[i][0]-1,edges[i][1]-1)) 
            return edges[i];
        }
        return new int[0];
    }
}
