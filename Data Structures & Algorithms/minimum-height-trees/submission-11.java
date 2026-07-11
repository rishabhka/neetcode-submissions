class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n==1)
        return new ArrayList<>(Arrays.asList(0));
        // else if(n==2)
        // {
        //     return new ArrayList<>(Arrays.asList(0,1));
        // }
        
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
        adjList.add(new ArrayList<>());
        int [] indegree = new int[n] ;
        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
            indegree[edges[i][0]] ++ ;
            indegree[edges[i][1]] ++ ;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        if(indegree[i]==1) q.add(i);
        int remaining = n;
        while(remaining>2)
        {
            int size = q.size() ; // i have to peel all these and proces
            remaining = remaining-size; 
            for(int i=0;i<size;i++)
            {
            int node = q.poll();
            for(int neigh : adjList.get(node))
            {
                indegree[neigh] -- ;
                if(indegree[neigh]==1)
                q.add(neigh);
            }
            }

        }
        while(!q.isEmpty())
        res.add(q.poll());
        return res ;
    }
}