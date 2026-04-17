class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)
        return new ArrayList<>(Arrays.asList(0));
        List<List<Integer>> adjList = new ArrayList<>();
        int [] indegree = new int [n] ;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
            indegree[edges[i][0]] ++ ;
            indegree[edges[i][1]] ++ ;
        }
        // int node = 0;
        int [] visited = new int [n] ;
        Queue<Integer> q = new LinkedList<>();
        List<String> path = new ArrayList<>();
        // q.add(node);
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==1)
            {
            q.add(i);
            // visited[i]= 1;
            }

        } 
        int count = n ;
        while(count>2)
        {
            int size = q.size();
            count = count - q.size();
            for(int k=0;k<size;k++)
            {
            int node = q.poll();
            if(visited[node]==1)
            continue ;
            visited[node]= 1;
            // count --;
            for(int i=0;i<adjList.get(node).size();i++)
            {
                int neigh = adjList.get(node).get(i);
                indegree[neigh]--;
                if(indegree[neigh]==1)
                {
                q.add(neigh);
                }
            }
            }
        }
        System.out.println(q.size());
            result.add(q.poll());
            if(!q.isEmpty())
            result.add(q.poll());
        return result ;

    }
}