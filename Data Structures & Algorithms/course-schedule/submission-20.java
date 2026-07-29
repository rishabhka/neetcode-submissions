class Solution {
    public boolean dfs(List<List<Integer>> adjList,int [] visited,int i)
    {
        if(visited[i]==1)
        return true;
        else if(visited[i]==2) return false;
        visited[i]=1 ;
        for(int neigh : adjList.get(i))
        {
            if(dfs(adjList,visited,neigh)) return true;
        }
        visited[i]=2  ;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>()) ;
        for(int i=0;i<prerequisites.length;i++)
        {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]) ;
        }
        int [] visited = new int [numCourses] ; // 0 -> not visited , 1-> cycle(top of stack) ,2->processoed
        for(int i=0;i<numCourses;i++)
        if(dfs(adjList,visited,i) ) return false ;

        for(int i=0;i<visited.length;i++)
        if(visited[i]==0) return false;

        return true ;
    }
}
