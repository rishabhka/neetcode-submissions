class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>()) ;
        int [] indegree = new int [numCourses] ;
        for(int i=0;i<prerequisites.length;i++)
        {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]) ;
            indegree[prerequisites[i][1]] ++ ;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        if(indegree[i]==0) q.offer(i) ;


        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int neigh :adjList.get(node))
            {
                indegree[neigh] -- ;
                if(indegree[neigh]==0)
                q.offer(neigh) ;

            }
        }
        for(int i=0;i<numCourses;i++)
        if(indegree[i]!=0) return false ;

        return true ;
    }
}
