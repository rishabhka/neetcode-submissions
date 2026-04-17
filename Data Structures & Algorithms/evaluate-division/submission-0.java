class Solution {
    public class Edge
    {
        int dest ;
        double value ;
        Edge(int dest,double value)
        {
            this.dest = dest ;
            this.value = value ;
        } 
    }
    public double findDist(int src,int dest,List<List<Edge>> adjList, Double amount,int [] visited) 
    {
        
        visited[src] = 1 ;
        for(int i=0;i<adjList.get(src).size();i++)
        {
            Edge node = adjList.get(src).get(i);
            int neigh = node.dest;
            Double amt = node.value;
            if(neigh==dest)
            return amt * amount; 
            else
            if(visited[neigh]!=1)
            {
            Double x = findDist(neigh,dest,adjList,amount*amt,visited) ;  
            if(x==-1.0)
            continue ;
            return x ;
            }        
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<List<Edge>> adjList = new ArrayList<>(); 
        HashMap<String,Integer> nodetoIdx = new HashMap<>();
        List<String> nodes = new ArrayList<>();
        double[] result = new  double [queries.size()] ;
        int k=0;
        for(int i=0;i<equations.size();i++)
        {
            for(int j=0;j<equations.get(i).size();j++)
        {
            String node = equations.get(i).get(j);
            if(!nodetoIdx.containsKey(node))
            {
                nodetoIdx.put(node,k);
                nodes.add(node);
                k++;
            }
        }
        }
        for(int i=0;i<nodes.size();i++)
        adjList.add(new ArrayList<>());
        for(int i=0;i<equations.size();i++)
        {
            int src = nodetoIdx.get(equations.get(i).get(0)) ;
            int dest = nodetoIdx.get(equations.get(i).get(1)) ;
            Edge edge1 = new Edge(dest,values[i]); 
            Edge edge2 = new Edge(src,1/values[i]); 
            adjList.get(src).add(edge1);  
            adjList.get(dest).add(edge2);      
        }
        for(int i=0;i<queries.size();i++)
        {
            int src = nodetoIdx.getOrDefault(queries.get(i).get(0),-1);
            int dest = nodetoIdx.getOrDefault(queries.get(i).get(1),-1);
            if(src==dest&&src>=0)
            result[i]=1.0;
            else if(src==-1||dest==-1)
            result[i]=-1.0;
            else
            {
                int visited [] = new int [nodes.size()] ;
                Double x =  findDist(src,dest,adjList,1.0,visited); // normal
                // Double y =  findDist(dest,src,adjList,1.0); // reverse
                // System.out.println(x+" "+ y );
                result[i]=x;
            }
        }
        return result ;
    }
}