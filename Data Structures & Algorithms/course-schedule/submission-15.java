class Solution {
    public boolean cycle(List<List<Integer>> adjList,int [] visited ,int node)
    {
        if(visited[node]==2)
        return true;
        visited[node]=2;
        for(int i=0;i<adjList.get(node).size();i++)
        {
            int neigh = adjList.get(node).get(i);
            if(cycle(adjList,visited,neigh))
            return true;
        }
        visited[node]=1;
        return false;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0) return true ;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>());
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<prerequisites.length;i++)
        {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
            q.add(prerequisites[i][0]);
        }
        // q.add(0); 
        int [] visited = new int[numCourses] ;
        for(int i=0;i<numCourses;i++)
        if(cycle(adjList,visited,i)) return false;
        return true ;
        // return cycle(adjList,visited,0)==true?false:true;
        // while(!q.isEmpty())
        // {
        //     int node = q.poll();
        //     visited[node] = 2;
        //     for(int i=0;i<adjList.get(node).size();i++)
        //     {
        //         int neigh = adjList.get(node).get(i);
        //         if(visited[neigh]==2)
        //         return false ;
        //         q.add(neigh);
        //     }
        //     visited[node] = 1;

        // }
        // return true ;
    }
}
