class Solution {
    public Boolean check(List<List<Integer> > adjList,int src,int dest,int [] visited,Boolean [][] dp)
    {
        Boolean k = false ;
        if(dp[src][dest]!=null)
        return dp[src][dest] ;
        for(int i=0;i<adjList.get(src).size();i++)
        {
            int neigh = adjList.get(src).get(i) ;
            if(neigh==dest)
            return true ;
            k = k || check(adjList,neigh,dest,visited,dp);
            if(!k)
            continue ;
            else return true ;
        }
        dp[src][dest] = k;
        return k;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer> > adjList = new ArrayList<>();
        List<Boolean> result = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++)
        adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        int [] visited = new int [numCourses] ;
        Boolean [][] dp = new Boolean [numCourses][numCourses];
        for(int [] query:queries)
        result.add(check(adjList,query[0],query[1],visited,dp));
        return result ;
    }
}