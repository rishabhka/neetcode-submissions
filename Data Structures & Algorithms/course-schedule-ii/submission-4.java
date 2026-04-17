class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer> > adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>());
        int [] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++)
        {
        adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        indegree[prerequisites[i][0]] = indegree[prerequisites[i][0]] +1 ;
        }
        int [] visited = new int [numCourses] ;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int node = q.poll();
            result.add(node);
            visited[node] = 1 ;
            for(int j=0;j<adjList.get(node).size();j++)
            {
                int neigh = adjList.get(node).get(j);
                if(visited[neigh]==1)
                continue ;
                indegree[neigh] -- ;
                if(indegree[neigh]==0)
                q.add(neigh);
            }
        }
        if(result.size()!=numCourses)
        return new int [0] ;
        int [] y = new int[result.size()];
        for(int i=0;i<result.size();i++)
        y[i]=  result.get(i) ;
        return y ;
    }
}
