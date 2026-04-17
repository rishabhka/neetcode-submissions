class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        HashSet<Integer> processsed = new HashSet<>();
        int count =0;

        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>());

        int [] indegree = new int [numCourses];

        for(int i=0;i<prerequisites.length;i++)
        {
        indegree[prerequisites[i][1]]++;
        adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        if(indegree[i]==0)
        q.add(i);

        while(!q.isEmpty())
        {
            
            int current_node = q.poll();
            System.out.println(current_node);
            count ++ ;
            for(int i=0;i<adjList.get(current_node).size();i++)
            {
                int neigh = adjList.get(current_node).get(i);
                
                indegree[neigh]= indegree[neigh]-1;
                if(indegree[neigh]==0)
                {
                q.add(neigh) ;
                }
            }

        }
        return count == numCourses ? true :false ;
    }
}
