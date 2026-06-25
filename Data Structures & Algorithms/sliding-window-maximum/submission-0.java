class Solution {
    class Tuple
    {
        int value ;
        int idx ;
        Tuple(int value, int idx)
        {
            this.value = value ;
            this.idx = idx ;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)-> Integer.compare(b.value,a.value));
        int size = nums.length - k + 1 ;
        int [] result = new int [size] ;

        for(int i=0;i<k-1;i++)
        pq.add(new Tuple(nums[i],i));

        int i=0; int j=k-1; 
        while(j<nums.length)
        {
            pq.add(new Tuple(nums[j],j));
            while(pq.peek().idx<i)
            pq.poll();

            result[i] = pq.peek().value;

            i++;
            j++;
        }
        return result;
        
    }
}
