class Solution {
    class Node
    {
        String neigh ; Double val ;
        Node(String neigh , Double val) {this.neigh=neigh;this.val=val;} 
    }
    public double dfs(HashMap<String,List<Node>> map,String src,String dest,HashSet<String> set,double acc)
    {
        if(src.equals(dest))
        return acc ;
        set.add(src);
        for(int i=0;i<map.get(src).size();i++)
        {
            Node neigh = map.get(src).get(i) ;
            // if(neigh.neigh.equals(dest))
            // return dist ;
            if(set.contains(neigh.neigh))
            continue ;
            double xv = dfs(map,neigh.neigh,dest,set,acc*neigh.val) ;
            if(xv!=-1)
            return xv;
        }
        return -1;

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        HashMap<String,List<Node>> map = new HashMap<>();
        for(int i=0;i<equations.size();i++)
        {
            if(!map.containsKey(equations.get(i).get(0)))
            map.put(equations.get(i).get(0),new ArrayList<>());
            map.get(equations.get(i).get(0)).add(new Node(equations.get(i).get(1),values[i]));
            if(!map.containsKey(equations.get(i).get(1)))
            map.put(equations.get(i).get(1),new ArrayList<>());
            map.get(equations.get(i).get(1)).add(new Node(equations.get(i).get(0),1/values[i]));
        }
        for(int i=0;i<queries.size();i++)
        {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            if(!map.containsKey(src)|| !map.containsKey(dest))
            res[i] = -1.0;
            else
            {
            HashSet<String> visited = new HashSet<>();  
            res[i] = dfs(map,src,dest,visited,1);
            }
        }
        return res;
    }
}