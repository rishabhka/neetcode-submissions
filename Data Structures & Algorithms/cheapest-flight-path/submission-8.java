class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int []>>  adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
        adjList.add(new ArrayList<>());

        for(int i=0;i<flights.length;i++)
        {
            adjList.get(flights[i][0]).add(new int [] {flights[i][1],flights[i][2]});
        }
        int [] visited = new int [n];
        PriorityQueue<int [] > q = new PriorityQueue<>(
            (a,b)->
            {
                return Integer.compare(a[1],b[1]);
            }
        );
        q.offer(new int [] {src,0,0}) ; 
        while(!q.isEmpty())
        {
            int [] node = q.poll();
            if(node[2]-1>k) continue ; 
            if(node[0]==dst)
            return node[1] ;
            
            for(int [] neigh : adjList.get(node[0]))
            {
                
                if(visited[neigh[0]]==1)
                continue ;
                int newDist = node[1] + neigh[1] ;
                q.offer(new int [] {neigh[0],newDist,node[2]+1}) ;
            }
        }
        return -1; 
    }
}
