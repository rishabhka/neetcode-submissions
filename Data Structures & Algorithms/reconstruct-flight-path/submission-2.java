class Solution {
    public void dfs(HashMap<String,List<String>> adjList,String node,List<String> path)
    {
        // if(adjList.get(node).size()==0)
        // return ;     
        List<String> neighbours = adjList.get(node) ;
        while(neighbours!=null&&neighbours.size()!=0)
        {
            String neigh = neighbours.get(0);
            neighbours.remove(0);
            dfs(adjList,neigh,path);

        }
        path.add(node) ;
        return ;
        
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String ,List<String>> adjList = new HashMap<>();
        // HashSet<String>  nodes = new HashSet<>();

        for(int i=0;i<tickets.size();i++)
        {
            if(!adjList.containsKey(tickets.get(i).get(0)))
            {
                adjList.put(tickets.get(i).get(0),new ArrayList<>(Arrays.asList(tickets.get(i).get(1)))); 
            }
            else
                adjList.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }
        adjList.forEach( (key,value)->
        {
            Collections.sort(value);
        });
        List<String> path = new ArrayList<>();
        dfs(adjList,"JFK",path);
        Collections.reverse(path);
        return path;
    }
}
