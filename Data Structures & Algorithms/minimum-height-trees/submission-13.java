class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int [] indegree = new int[n] ;
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++)
        adjList.add(new ArrayList<>()) ;

        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]) ;
            adjList.get(edges[i][1]).add(edges[i][0]) ;
            indegree[edges[i][0]] ++ ;
            indegree[edges[i][1]] ++ ;
        }
        Queue<Integer> q = new LinkedList<>();
        // int [] visited = new int[n] ;
        for(int i=0;i<indegree.length;i++)
        if(indegree[i] == 1) q.offer(i) ;
        int remaining = n;
        while (remaining > 2) 
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
            int node = q.poll();
            for(int neigh : adjList.get(node))
            {
                indegree[neigh] -- ;
                if(indegree[neigh]==1) 
                q.offer(neigh) ; 
                
            }
            indegree[node] = -1 ;
            remaining--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<indegree.length;i++)
        if(indegree[i] >= 0) res.add(i) ;
        return res ;
    }
}