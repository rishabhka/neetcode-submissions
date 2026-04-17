class Solution {
    public int countComponents(int n, int[][] edges) {

       List<List<Integer> > adjList = new ArrayList<>();
       HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++)
        {
        adjList.add(new ArrayList<>());
        set.add(i);
        }
        for(int i=0;i<edges.length;i++)
        {
        adjList.get(edges[i][0]).add(edges[i][1]);
        adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int [] visited = new int [n] ;
        Queue<Integer> q = new LinkedList<>();
        // q.add(0);
        int count =0;
        while(!set.isEmpty())
        {
        count ++;
        q.add(set.iterator().next());
        while(!q.isEmpty())
        {
            int node = q.poll();
            if(visited[node]==1)
            continue ;
            visited[node]=1;
            set.remove(node);
            for(int j=0;j<adjList.get(node).size();j++)
            {
                int neigh = adjList.get(node).get(j);
                q.add(neigh);
            }
        }
        }
        return count ;

    }
}
