class Solution {
    public boolean detectCycle(List<List<Integer>> adjList,int parent,int node ,int [] visited)
    {
        visited[node] = 1 ;
        boolean flag = false;
        for(int i=0;i<adjList.get(node).size();i++)
        {
            int neigh = adjList.get(node).get(i);
            if(neigh==parent)
            continue ;
            else if(neigh!=parent&&visited[neigh]==1)
            return true ;
            else if(neigh!=parent&&visited[neigh]!=1)
            flag = flag || detectCycle(adjList,node,neigh,visited) ;
            
        }
        return flag ;
    }
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<=edges.length;i++)
        adjList.add(new ArrayList<>());
        
        
        for(int i=0;i<edges.length;i++)
        {
            int [] visited = new int [edges.length+1] ;
        adjList.get(edges[i][1]).add(edges[i][0]);
        adjList.get(edges[i][0]).add(edges[i][1]);
        if(detectCycle(adjList,-1,edges[i][0],visited))
        return new int []{edges[i][0],edges[i][1]};
        }
        return new int []{};
    }
}
