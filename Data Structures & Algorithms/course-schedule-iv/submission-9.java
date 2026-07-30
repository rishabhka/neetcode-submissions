class Solution {
    public boolean dfs(List<List<Integer> > adjList,int src,int trg,boolean [] visited)
    {
        if(src==trg) return true ;
        visited[src] = true ;
        for(int neigh : adjList.get(src))
        {
            if(trg==neigh) return true ;
            if(visited[neigh]==true) continue ;
            if(dfs(adjList,neigh,trg,visited) ) return true ;
        }
        return false;

    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer> > adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        adjList.add(new ArrayList<>()) ;

        for(int i=0;i<prerequisites.length;i++)
        {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]) ;
        }
        List<Boolean > res = new ArrayList<>();
        for(int i=0;i<queries.length;i++)
        {
            boolean [] visited = new boolean [numCourses] ;
            if(dfs(adjList,queries[i][0],queries[i][1],visited)) 
            res.add(true) ;
            else res.add(false) ;
        }
        return res ;
    }
}