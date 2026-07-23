class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int n = nums.length -1 ;
        int [] res = new int[n-k+2] ;
        for(int i=0;i<k;i++)
        {
            while(!q.isEmpty()&&nums[i]>nums[q.peekLast()])
            q.pollLast() ;
            q.offerLast(i) ;
        }
        res[0]  = nums[q.peekFirst()];
        for(int i=k,j=1;i<nums.length;i++,j++)
        {
            while(!q.isEmpty()&&nums[i]>nums[q.peekLast()])
            q.pollLast() ;
            while(!q.isEmpty()&&q.peekFirst()<=i-k)
            q.pollFirst() ;
            q.offerLast(i) ;
            res[j] = nums[q.peekFirst()];
        }
        return res ;
    }
}
