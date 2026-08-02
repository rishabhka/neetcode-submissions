class Solution {
    public void dfs(HashMap<String,List<String>> adjList,String src,List<String> res)
    {
        while(adjList.get(src).size()!=0)
        {
            String neigh = adjList.get(src).get(0) ;
            adjList.get(src).remove(0) ;
            dfs(adjList,neigh,res) ;      
        }
        res.add(src) ;

    }
    public List<String> findItinerary(List<List<String>> ticket) {
        HashMap<String,List<String>> adjList  = new HashMap<>();
        for(int i=0;i<ticket.size();i++)
        {
            if(!adjList.containsKey(ticket.get(i).get(0)))
            adjList.put(ticket.get(i).get(0),new ArrayList<>());
            if(!adjList.containsKey(ticket.get(i).get(1)))
            adjList.put(ticket.get(i).get(1),new ArrayList<>());
            adjList.get(ticket.get(i).get(0)).add(ticket.get(i).get(1)) ;
        }
        adjList.forEach((k,v)->
        {
            Collections.sort(v) ;
        });
        List<String> res = new ArrayList<>();
        dfs(adjList,"JFK",res) ;
        Collections.reverse(res) ;
        return res ;
    }
}
