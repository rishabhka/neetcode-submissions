class Solution {

    int [] parent ;
    int [] rank ;

    public int checkParent(int n1)
    {
        while(n1!=parent[n1])
        n1 = parent[n1];

        return n1;

    }

    public boolean cycle(List<List<Integer>> adjList,int n1,int n2)
    {
        int x = checkParent(n1);
        int y = checkParent(n2) ;
        if(x==y)
        return true ;
        else if(rank[x]>=rank[y])
        {
            rank[x]= rank[x]+1;
            parent[y] = parent[x] ;
        }
        else
        {
            rank[y]= rank[y]+1;
            parent[x] = parent[y] ;
        }
        return false ;

    }
    
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = edges.length+1 ;

        parent = new int [n] ;
       rank = new int [n] ;
        
        for(int i=0;i<=edges.length;i++)
        {
        adjList.add(new ArrayList<>());
        parent[i] = i ;
        rank[i] = 1;
        }
        
        for(int i=0;i<edges.length;i++)
        {
        adjList.get(edges[i][1]-1).add(edges[i][0]-1);
        adjList.get(edges[i][0]-1).add(edges[i][1]-1);
        if(cycle(adjList,edges[i][0]-1,edges[i][1]-1))
        return new int [] {edges[i][0],edges[i][1]} ;
        }
        return new int [] {} ;
    }
}
