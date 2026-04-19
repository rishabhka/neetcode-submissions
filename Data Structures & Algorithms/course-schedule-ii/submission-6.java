class Solution {
    int [] order  ;
    int ptr ;
    public boolean dfs(List<List<Integer>> adjList,int [] visited,int i)
    {
        if(visited[i]==1)
        return true ;
        else if(visited[i]==2)
        return false ;
        visited[i] = 1;
        
        for(int j=0;j<adjList.get(i).size();j++)
        {
            int neigh = adjList.get(i).get(j);
            if(dfs(adjList,visited,neigh))
            return true ;
        }
        order[ptr] = i;
        ptr--;
        visited[i] = 2;
        return false;

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        order = new int [numCourses] ;
        ptr = numCourses-1;
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++)
        {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int [] visited = new int [numCourses] ;
        for(int i=0;i<numCourses;i++)
        {
        if(visited[i]==0)
        {
        if(dfs(adjList,visited,i))
        {     
        return new int [0] ;
        }
        }
        }
        return order ;
    }
}
