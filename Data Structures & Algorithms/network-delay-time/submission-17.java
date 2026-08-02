class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int []>> adjList = new LinkedList<>();
        for(int i=0;i<n;i++)
        adjList.add(new ArrayList<>()) ;
        for(int i=0;i<times.length;i++)
        {
            adjList.get(times[i][0]-1).add(new int[] {times[i][1]-1,times[i][2]}) ;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{return Integer.compare(a[1],b[1]);}) ;
        int [] distance = new int[n] ;
        Arrays.fill(distance,Integer.MAX_VALUE) ;
        distance[k-1] = 0;
        int [] visited = new int [n] ;
        q.add(new int[]{k-1,0}) ;

        while(!q.isEmpty())
        {
            int [] node = q.poll() ;
            visited[node[0]] = 1 ;
            for(int [] neigh: adjList.get(node[0]))
            {
                if(visited[neigh[0]]==1) continue ;
                if(distance[neigh[0]]>neigh[1]+node[1])
                {
                    distance[neigh[0]]=neigh[1]+node[1] ;
                    q.offer(new int []{neigh[0],distance[neigh[0]]}) ;
                }
            }
        }
        int max = 0;
        for(int i=0;i<distance.length;i++)
        {
            max = Math.max(max,distance[i]) ;
            if(visited[i]==0) return -1 ;
        }
        return max ;

    }
}
