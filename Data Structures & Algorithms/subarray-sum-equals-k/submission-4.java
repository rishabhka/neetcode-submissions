class Solution {
    public int subarraySum(int[] nums, int k) {
        int current =0 ;
        HashMap<Integer,Integer > freq = new HashMap<>();
        int count =0 ;
        freq.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            current = current + nums[i] ;
            // if(current==k)
            // count ++ ;
            if(freq.containsKey(current-k))
            count = count + freq.get(current-k);
            int prefix = current - nums[i] ;
            freq.put(current,freq.getOrDefault(current,0)+1);

        }
        
        return count ;
    }
}