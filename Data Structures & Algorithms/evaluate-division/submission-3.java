class Solution {
    class Node 
    {
        double val ; String node ;
        Node(double v, String s){ val = v; node = s;}
    }
    public double dfs(HashMap<String,List<Node>> adjList,String src,String dest,double ans,HashSet<String> visited )
    {
        if(src.equals(dest)) return ans ;
        visited.add(src) ;
        if(!adjList.containsKey(src)) return -1 ;
        for(Node neigh : adjList.get(src) )
        {
            if(visited.contains(neigh.node)) continue ;
            double x =dfs(adjList,neigh.node,dest,ans*neigh.val,visited) ;
            if(x!=-1.0) return x ;
        }
        return -1.0 ;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,List<Node>> adjList = new HashMap<>();
        for(int i=0;i<equations.size();i++)
        {
            if(!adjList.containsKey(equations.get(i).get(0)))
            adjList.put(equations.get(i).get(0),new ArrayList<>()) ;
            if(!adjList.containsKey(equations.get(i).get(1)))
            adjList.put(equations.get(i).get(1),new ArrayList<>()) ;
            adjList.get(equations.get(i).get(0)).add(new Node(values[i],equations.get(i).get(1))) ;
            adjList.get(equations.get(i).get(1)).add(new Node(1/values[i],equations.get(i).get(0))) ;
        }
        double [] res = new double [queries.size()];
        for(int i=0;i<queries.size();i++)
        {
            HashSet<String> visited = new HashSet<>() ;
            if(!adjList.containsKey(queries.get(i).get(1)))
            res[i] = -1.0; 
            else
            res [i] = dfs(adjList,queries.get(i).get(0),queries.get(i).get(1),1.0,visited) ;
        }
        return res ;
    }
}