class Solution {
    public boolean cycle(List<List<Integer>> adjList,int [] visited ,int node,List<Integer> temp)
    {
        if(visited[node]==2)
        return true;
        else if(visited[node]==1)
        return false;
        visited[node]=2;
        
        for(int i=0;i<adjList.get(node).size();i++)
        {
            int neigh = adjList.get(node).get(i);
            if(cycle(adjList,visited,neigh,temp))
            return true;
        }
        temp.add(node);
        visited[node]=1;
        return false;

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] order = new int[numCourses] ;
        if(numCourses==0) return new int[]{} ;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++)
        {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int [] visited = new int[numCourses] ;
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
        if(cycle(adjList,visited,i,temp)) return new int[]{};
        }
        for(int i=0;i<numCourses;i++)
        order[i] = temp.get(i);
        return order ;
    }
}
