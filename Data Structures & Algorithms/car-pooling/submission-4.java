class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
       Arrays.sort(trips,(a,b)->
       {
        return Integer.compare(a[1],b[1]) ;
       }) ;
       PriorityQueue<int[] > pq = new PriorityQueue<>((a,b)->
       {
       return Integer.compare(a[2],b[2]);
       }
       );
       int curr  = 0;
       int trip_end = 0 ;
       for(int i=0;i<trips.length;i++)
       {
        // remove all expired children
        while(!pq.isEmpty()&&pq.peek()[2]<=trips[i][1])
        {
            int [] c = pq.poll();
            curr = curr - c[0] ;
        }
        // board new children
        curr = curr + trips[i][0] ;
        if(curr>capacity) return false;
        pq.offer(trips[i]) ;
       }
       return true ;
    }
}