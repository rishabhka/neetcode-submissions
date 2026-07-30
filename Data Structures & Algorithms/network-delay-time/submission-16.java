class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int []>> adjList = new ArrayList<>() ;
        for(int i=0;i<n;i++)
        adjList.add(new ArrayList<>()) ;

        for(int i=0;i<times.length;i++)
        {
            adjList.get(times[i][0]-1).add(new int[]{times[i][1]-1,times[i][2]}) ;
        }
        int [] visited = new int [n] ;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->
        {
            return Integer.compare(a[1],b[1]) ;
        });
        int [] distance = new int [n] ;
        Arrays.fill(distance,Integer.MAX_VALUE) ;
        pq.offer(new int []{k-1,0}) ; int min = Integer.MIN_VALUE ;
        distance[k-1]= 0;
        while(!pq.isEmpty())
        {
            int [] node = pq.poll();
            visited[node[0]] = 1;
            
            for(int [] neigh : adjList.get(node[0]))
            {
                if(visited[neigh[0]]==1) continue ;
                int newDist = node[1] + neigh[1] ;
                if(distance[neigh[0]]>newDist)
                {
                    pq.offer(new int[]{neigh[0],newDist}) ;
                    distance[neigh[0]]=newDist ;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
        if(visited[i]==0) return -1;
        min = Math.max(distance[i],min) ;
        }

        return min ;
    }
}
