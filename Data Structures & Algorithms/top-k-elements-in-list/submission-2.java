class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int [] > pq = new PriorityQueue<>((a,b)->(Integer.compare(b[1],a[1])));
        HashMap<Integer,Integer> map = new HashMap<>() ;
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        // for(int i=0;i<)
        map.forEach((key,value)->
        { pq.add(new int[]{key,value}) ;
    }) ;
        // System.out.println(pq.size());
        int [] result = new int[k] ;
        while(k!=0)
        {
            int [] temp = pq.poll() ;
            result[k-1] = temp[0];
            // pq.poll();
            k-- ;
        }
        return result ;
    }
}
