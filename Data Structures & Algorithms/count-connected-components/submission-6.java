class Solution {
    int [] parent ;
    int [] rank ;
    HashSet<Integer> visited = new HashSet<>();
    public void dfs(List<List<Integer>> adjList,int parent,int i)
    {
        for(int j=0;j<adjList.get(i).size();j++)
        {
            int neigh = adjList.get(i).get(j) ;
            // if(neigh==parent)
            // continue ;
            if(visited.contains(neigh))
            continue ;
            visited.add(neigh);
            dfs(adjList,i,neigh);
        }
        return ;

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
        int comp =0;
        // parent = new int[n];
        // rank = new int[n];

        
        for(int i=0;i<n;i++)
        {
            if(!visited.contains(i))
            {
            visited.add(i);
            System.out.println(i);
            dfs(adjList,-1,i);
            comp++;
            }
        }
        return comp;
    }
}
