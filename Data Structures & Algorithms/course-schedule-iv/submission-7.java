class Solution {
    public boolean dfs(List<List<Integer>> adjList,int src,int dst,int [] visited,Boolean [][] memo)
    {
        if(src==dst) return true ;
        else if(memo[src][dst]!=null) return memo[src][dst];
        visited[src] = 1;
        for(int neigh : adjList.get(src) )
        {
            if(visited[neigh]==1)
            continue ;
            if(dfs(adjList,neigh,dst,visited,memo))
            {
            memo[src][dst]= true ;
            return memo[src][dst];
            }
        }
        memo[src][dst]= false;
        return memo[src][dst];

    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        Boolean [][] memo = new Boolean [numCourses][numCourses] ;
        // for(int i=0;i<n;i++)
        // Arrays.fill(memo[i],-1);
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++)
        {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i=0;i<queries.length;i++)
        {
            int [] visited = new int [numCourses] ;
            if(dfs(adjList,queries[i][0],queries[i][1],visited,memo))
            res.add(true);
            else 
            res.add(false);
        }
        return res ;
    }
}