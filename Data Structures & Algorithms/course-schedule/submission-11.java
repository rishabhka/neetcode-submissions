class Solution {
    // 0 - not visited
    // 2 - Processed and out of stack
    //1 - On stack 
    public boolean cycleDetect(List<List<Integer>> adjList,int [] visited,int vert)
    {
        if(visited[vert]==1)
        return true ;
        else if(visited[vert] == 2)
        return false;
        visited[vert] = 1 ;
        for(int j=0;j<adjList.get(vert).size();j++)
        {
            int neigh = adjList.get(vert).get(j);
            if(cycleDetect(adjList,visited,neigh))
            return true ;
        }
        visited[vert] = 2 ;
        return false ;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int [] visited = new int [numCourses] ;
        for(int i=0;i<numCourses;i++)
        adjList.add(i,new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++)
        {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i=0;i<numCourses;i++)
        {
            if(cycleDetect(adjList,visited,i))
            return false ;
        }
        return true ;

    }
}
