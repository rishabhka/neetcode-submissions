class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int []>> adjList = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> Integer.compare(a[1],b[1])
        );
        for(int i=0;i<n;i++)
        adjList.add(new ArrayList<>());

        for(int i=0;i<times.length;i++)
        {
            adjList.get(times[i][0]-1).add(new int[]{times[i][1]-1,times[i][2]});
        }
        int [] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1] = 0; 
        pq.add(new int[]{k-1,0}); //(node,dist from src)
         
        while(!pq.isEmpty())
        {
            int [] node = pq.poll();
            for(int [] neigh: adjList.get(node[0]))
            {
                int newDist = node[1] + neigh[1] ;
                if(newDist<dist[neigh[0]]) 
                {
                    dist[neigh[0]]=newDist;
                    pq.add(new int[]{neigh[0],dist[neigh[0]]});
                }
            }
        }
        int max =0;
        for(int i=0;i<dist.length;i++)
        max = Math.max(max,dist[i]);
        if(max==Integer.MAX_VALUE) 
        return -1; 
        else return max ;

    }
}
