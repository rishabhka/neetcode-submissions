class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int [] dist = new int [n];
        int [] visited = new int [n];
        List<List<int []>> adjList = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
        adjList.add(new ArrayList<>());
        dist[i] = Integer.MAX_VALUE ;
        }

        dist[k-1] = 0 ;

        for(int i=0;i<times.length;i++)
        {
            adjList.get(times[i][0]-1).add(new int []{times[i][1]-1,times[i][2]});
        }
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->
        {
            return Integer.compare(a[1],b[1]);
        });

        pq.add(new int[]{k-1,0});

        while(!pq.isEmpty())
        {
            int [] node = pq.poll();
            if(visited[node[0]]==1)
            continue ;
            visited[node[0]] = 1 ;
            for(int j=0;j<adjList.get(node[0]).size();j++)
            {
                int [] neigh = adjList.get(node[0]).get(j);
                // if(visited[neigh[0]]==1)
                // continue ;
                dist[neigh[0]]= Math.min(neigh[1]+node[1],dist[neigh[0]]);
                pq.add(new int[]{neigh[0],neigh[1]+node[1]});
            }

        }
        int max_value = 0;
        for(int i=0;i<n;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
            return -1;
            max_value = Math.max(max_value ,dist[i]); 
        }
        return max_value ;

    }
}
