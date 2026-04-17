class Solution {
    public class Node
    {
        int node ;
        int time ;
        Node(int node , int time)
        {
            this.node = node ;
            this.time = time ;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int []> > adjList = new ArrayList<>();
        int [] visited = new int [n] ;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->(a.time-b.time));
        int [] distance = new int [n] ;
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k-1] = 0;
        int min_time = Integer.MIN_VALUE ;

        for(int i=0;i<n;i++)
        adjList.add(new ArrayList<>());

        for(int i=0;i<times.length;i++)
        {
            adjList.get(times[i][0]-1).add(new int[]{times[i][1]-1,times[i][2]});
        }

        pq.add(new Node (k-1,0));

        while(!pq.isEmpty())
        {
            
            Node vertex = pq.poll();
            int source = vertex.node ;
            int srcDist = vertex.time ;

            System.out.println(source);

            if(visited[source]==1)
            continue ;

            for(int i=0;i<adjList.get(source).size();i++)
            {
                int neigh = adjList.get(source).get(i)[0];
                int neighDist = adjList.get(source).get(i)[1];

                visited[source] = 1 ;

                pq.add(new Node (neigh,neighDist+srcDist));

                if(distance[neigh]>neighDist+srcDist)
                distance[neigh]=neighDist+srcDist ;
            }
        }
        for(int i=0;i<n;i++)
        {
          min_time = Math.max(min_time,distance[i]);  
        }

        // for(int i=0;i<distance.length;i++)
        // System.out.println(distance[i]);

        return min_time == Integer.MAX_VALUE ? -1 : min_time;


        
    }
}
