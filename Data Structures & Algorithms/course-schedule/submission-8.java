class Solution {
    //0 -> Unvisited
    //1 -> Visited
    //2 -> On stack
    public boolean dfs(List<List<Integer> > adjList,int [] visited,int i)
    {
        if(visited[i]==2)
        return false;
        else if(visited[i]==1)
        return true ;
        else
        {
            visited[i] = 2;
            for(int j=0;j<adjList.get(i).size();j++)
            {
                int neigh = adjList.get(i).get(j);
                if(!dfs(adjList,visited,neigh))
                return false ;
            }
            visited[i] = 1;
        }
        return true ;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer> > adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++)
        adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        int [] visited = new int [numCourses] ;
        for(int i=0;i<numCourses;i++)
        {
            if(visited[i]==0)
            {
                if(!dfs(adjList,visited,i))
                return false;
            }
        }
        return true ;
    }
}
