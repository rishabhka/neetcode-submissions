class Solution {
    HashSet<Integer> visited = new HashSet<>();
    public boolean cycleDetect(List<List<Integer>> adjList,int parent,int i)
    {
        for(int j=0;j<adjList.get(i).size();j++)
        {
            int neigh = adjList.get(i).get(j) ;
            if(neigh==parent)
            continue ;
            if(visited.contains(neigh))
            return true ;
            visited.add(neigh);
            if(cycleDetect(adjList,i,neigh))
            return true ;
        }
        return false;

    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1)
        return false;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
        adjList.add(i,new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        visited.add(0);
        if(cycleDetect(adjList,-1,0))
        return false ;
        if(visited.size()==n)
        return true ;
        else return false ;
    }
}
