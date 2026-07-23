class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[] > pq = new PriorityQueue<>((a,b)->
        {
            return Integer.compare(b[1],a[1]);
        }) ;
        int [] res = new int[nums.length-k+1];
        for(int i=0;i<k;i++)
        pq.offer(new int[]{i,nums[i]}) ;
        res[0] = pq.peek()[1] ;
        for(int i=k;i<nums.length;i++)
        {
            pq.offer(new int[]{i,nums[i]}) ;
            while(pq.peek()[0]<=i-k) pq.poll() ;
            res[i-k+1] = pq.peek()[1] ;
            pq.offer(new int[]{i,nums[i]}) ;
        }
        return res ;

    }
}
