class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int []>> list = new ArrayList<>();

        for(int i=0;i<n;i++)
        list.add(new ArrayList<>());

        for(int i=0;i<times.length;i++)
        {
            list.get(times[i][0]-1).add(new int []{times[i][1]-1,times[i][2]});
        }
        PriorityQueue<int []> pq = new PriorityQueue<>(
        (a,b)->
        {
            return Integer.compare(a[1],b[1]);
        }
        );
        int []  visited = new int [n] ;
        int [] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.add(new int[] {k-1,0});
        // visited[k-1] =1 ;
        dist[k-1] =0  ;
        int max =0 ;
        while(!pq.isEmpty())
        {
            int [] node = pq.poll();

            if (dist[node[0]]<node[1]) continue;
            // if (node[1] > dist[node[0]]) continue;
            
            visited[node[0]]=1 ;
            
            if(node[1]>max) max = node[1] ;
            for(int [] neigh : list.get(node[0]) )
            {
                if(visited[neigh[0]]==1)
                continue ;

                int newdist = dist[node[0]] + neigh[1] ;
                if(newdist<dist[neigh[0]])
                {
                    pq.add(new int []{neigh[0],newdist});
                    dist[neigh[0]] = newdist;
                    // if(max<newdist) max = newdist; 
                }                             
            }
        }
        for(int i=0;i<n;i++)
        if(visited[i]==0) return -1;
        return max ;
    }
}
