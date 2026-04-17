class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[] > pq = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        List<List<int []> > adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
        adjList.add(new ArrayList<>());
        for(int [] time : times)
        {
          adjList.get(time[0]-1).add(new int [] {time[1]-1,time[2]});  
        }
        // int vertix = 0;
        int []  dist = new int [n] ;
        int [] visited = new int [n] ;
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1] = 0;
        pq.add(new int [] {k-1,0});   //(node,distance from src)
        while(!pq.isEmpty())
        {
            int [] node = pq.poll();
            if (node[1] > dist[node[0]]) continue;
            visited[node[0]] =1 ;
            for(int j=0;j<adjList.get(node[0]).size();j++)
            {
                int [] neigh = adjList.get(node[0]).get(j) ;
                if(dist[neigh[0]]>dist[node[0]]+neigh[1])
                {
                dist[neigh[0]] = dist[node[0]]+neigh[1] ;
                if(visited[neigh[0]]==0)
                pq.add(new int [] {neigh[0],dist[neigh[0]]});
                }                
            }

        }
        int max_value = Integer.MIN_VALUE ;
        for(int i=0;i<n;i++)
        {
            if(max_value<dist[i])
            max_value= dist[i];
        }
        return max_value==Integer.MAX_VALUE?-1:max_value ;
    }
}
