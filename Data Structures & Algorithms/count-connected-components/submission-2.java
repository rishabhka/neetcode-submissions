class Solution {
    public void dfs(List<List<Integer>> adjList,int [] visited,int node)
    {
        if(visited[node]==1)
        return ;
        visited[node]= 1;
        for(int i=0;i<adjList.get(node).size();i++)
        {
            int neigh = adjList.get(node).get(i);
            dfs(adjList,visited,neigh);
        }

    }
    public int countComponents(int n, int[][] edges) {

     List<List<Integer>> adjList = new ArrayList<>();

     for(int i=0;i<n;i++)
     adjList.add(new ArrayList<>());
     for(int i=0;i<edges.length;i++)
     {
     adjList.get(edges[i][0]).add(edges[i][1]);
     adjList.get(edges[i][1]).add(edges[i][0]);
     }
     int [] visited = new int[n]; 
     int count =0;
     for(int i=0;i<n;i++)
     {
        if(visited[i]==0)
        {
        dfs(adjList,visited,i);
        count ++;
        }
     }
     return count ;
    }
}
