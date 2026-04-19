class Solution {
    HashSet<Integer> visited = new HashSet<>();
    
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
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<n;i++)
        {
        if(!visited.contains(i))
        {
        visited.add(i);
        q.add(i);
        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int j=0;j<adjList.get(node).size();j++)
            {
                int neigh = adjList.get(node).get(j) ;
                if(!visited.contains(neigh))
                {
                    visited.add(neigh);
                    q.add(neigh);
                }
            }
        }
        comp++;
        }
        }
        
        
        return comp;
    }
}
