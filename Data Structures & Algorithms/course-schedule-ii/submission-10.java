class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] order = new int[numCourses] ;
        if(numCourses==0) return new int[]{} ;
        int [] indegree = new int[numCourses] ;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++)
        {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;  
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
        if(indegree[i]==0)
        q.add(i);
        } 
        int processod =0; 
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty())
        {
            int node = q.poll();
            processod++;
            result.add(node);
            for(int i=0;i<adjList.get(node).size();i++)
            {
                int neigh = adjList.get(node).get(i);
                indegree[neigh]--;
                if(indegree[neigh]==0)
                q.add(neigh);
            }
        }
        if (processod != numCourses) return new int[]{};       // cycle → empty
for (int i = 0; i < numCourses; i++)
    order[i] = result.get(i);
return order;
        
    }
}
