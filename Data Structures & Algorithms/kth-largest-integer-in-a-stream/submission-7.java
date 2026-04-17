class KthLargest {

    PriorityQueue<Integer> pq ;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a,b)->(a-b)) ; 
        int n = nums.length;
        this.k=k;

        for(int i: nums)
        {
            pq.add(i);
        }
        for(int i=0;i<n-k;i++)
        pq.poll();
        System.out.println(pq.size()+" "+pq.peek());

    }
    
    public int add(int val) {
        // if(pq.size()!=0&&pq.peek()>val)
        // return pq.peek();
        // else
        // {
        //     pq.add(val);
        //     if(pq.size()<=k)
        //     return pq.peek() ;
        //     else {
        //         pq.poll();
        //         return pq.peek();
        //     }
        // }
        pq.add(val);
        if(pq.size()>k)
        pq.poll();

        return pq.peek();
    }
}
