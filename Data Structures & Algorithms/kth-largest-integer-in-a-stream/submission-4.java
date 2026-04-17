class KthLargest {
    PriorityQueue<Integer> pq ;
    int k ;
    public KthLargest(int K, int[] nums) {
       k = K;
       int n = nums.length;
       pq = new PriorityQueue<>();
       for(int i=0;i<n;i++)
       {
       if(i<k)
       pq.add(nums[i]);
       else
       {
        if(nums[i]>pq.peek())
        {
            pq.poll();
            pq.add(nums[i]);
        }
       }
       }
       
    }
    
    public int add(int val) {
        if(pq.size()<k)
        pq.add(val);
        else if(val>pq.peek())
        {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
