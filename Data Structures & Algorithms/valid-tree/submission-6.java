class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1)
        return false ;
       List<List<Integer> > adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
        adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
        adjList.get(edges[i][0]).add(edges[i][1]);
        adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int [] visited = new int [n] ;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        // q.add(set.iterator().next());
        int count =0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            if(visited[node]==1)
            continue ;
            visited[node]=1;
            count ++;
            for(int j=0;j<adjList.get(node).size();j++)
            {
                int neigh = adjList.get(node).get(j);
                q.add(neigh);
            }
        }
        return count==n?true:false ;
    }
}
