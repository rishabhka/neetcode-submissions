class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        PriorityQueue<int [] > pq = new PriorityQueue<>((a,b)->
        {
            return Integer.compare(b[1],a[1]);
        });
        int []  res = new int[k];
        map.forEach((key,val)->
        {
            pq.add(new int[]{key,val}) ;
        }); int i=0 ;
        while(!pq.isEmpty())
        {
            res[i] = pq.poll()[0] ;
            if(k==1)
            break ;
            k--;
            i++;
        }
        return res;

    }
}
