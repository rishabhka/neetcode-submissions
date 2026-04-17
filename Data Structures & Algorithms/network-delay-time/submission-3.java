class Solution {
    public class Node
    {
        int x ; // src
        int y ;  // dest
        int dist ; // dist
        Node(int x , int y ,int dist )
        {
          this.x =x ;
          this.y =y;
          this.dist = dist ;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int [] >> adjList = new ArrayList<>();
        int [] visited = new int [n] ;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->(a.dist-b.dist));

        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++)
        {
            adjList.get(times[i][0]-1).add(new  int [] {times[i][1]-1,times[i][2]});
        }

        pq.add(new Node(k-1,0,0));
        int [] distance  = new int [n] ;
        Arrays.fill(distance,Integer.MAX_VALUE) ;

        distance[k-1] = 0;

        while(!pq.isEmpty())
        {
            Node current_node = pq.poll();
            int current = current_node.x;
            int curr_dist = current_node.dist ;

            for(int i=0;i<adjList.get(current).size();i++)
            {
                int neigh = adjList.get(current).get(i)[0] ;
                int neigh_dist = adjList.get(current).get(i)[1] ;

                if(distance[neigh]>curr_dist+neigh_dist)
                {
                distance[neigh]=curr_dist+neigh_dist ;
                pq.add(new Node (neigh,current,distance[neigh])) ;
                }

            }
        }
        int max_value =0 ;
        for(int i=0;i<n;i++)
        max_value = Math.max(max_value,distance[i]);

        return max_value == Integer.MAX_VALUE ? -1: max_value;
        
    }
}
