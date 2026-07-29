class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>()) ;
        int [] indegree = new int [numCourses] ;
        for(int i=0;i<prerequisites.length;i++)
        {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]) ;
            indegree[prerequisites[i][0]] ++ ;
        }
        Queue<Integer> q = new LinkedList<>() ;
        for(int i=0;i<numCourses;i++)
        if(indegree[i]==0) q.offer(i) ;
        int [] res = new int [numCourses] ; int i=0 ;
        while(!q.isEmpty())
        {
            int node = q.poll();
            res[i] = node ; i++;
            for(int neigh : adjList.get(node))
            {
                indegree[neigh] -- ;
                if(indegree[neigh]==0)
                q.offer(neigh) ;
            }
        }
        return i == numCourses ? res : new int[0] ;
    }
}
