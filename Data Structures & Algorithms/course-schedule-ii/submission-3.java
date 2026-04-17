class Solution {
    public boolean dfs(List<List<Integer> > adjList,int [] visited,int i,List<Integer> result)
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
                if(!dfs(adjList,visited,neigh,result))
                return false ;
            }
            result.add(i);
            visited[i] = 1;
        }
        return true ;

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer> > adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++)
        adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        int [] visited = new int [numCourses] ;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(visited[i]==0)
            {
                if(!dfs(adjList,visited,i,result))
                return new int [0] ;
            }
        }
        int [] y = new int[result.size()];
        for(int i=0;i<result.size();i++)
        y[result.size()-i-1]=  result.get(i) ;
        return y ;
    }
}
