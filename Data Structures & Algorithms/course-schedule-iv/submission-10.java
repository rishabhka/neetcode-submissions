class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer> > adjList = new ArrayList<>();
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        for(int i=0;i<numCourses;i++)
        {
        adjList.add(new ArrayList<>()) ;
        map.put(i,new HashSet<>()) ;
        }
        int [] indegree = new int [numCourses] ;
        for(int i=0;i<prerequisites.length;i++)
        {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]) ;
            indegree[prerequisites[i][1]] ++ ;
        }
        List<Boolean > res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>() ;
        for(int i=0;i<indegree.length;i++)
        if(indegree[i] == 0) q.offer(i) ;

        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int neigh :adjList.get(node))
            {
                map.get(neigh).add(node);
                map.get(neigh).addAll(map.get(node)) ;
                indegree[neigh] -- ;
                if(indegree[neigh]==0)
                q.offer(neigh) ;
            }
        }
        for(int [] query : queries)
        {
            if((query[0]==query[1])||map.get(query[1]).contains(query[0]))
            res.add(true) ;
            else res.add(false);
        }
        return res ;
    }
}