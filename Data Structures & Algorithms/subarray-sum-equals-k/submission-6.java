class Solution {
    public int subarraySum(int[] nums, int k) {
        // int [] prefix = new int [nums];
        HashMap<Integer,Integer> freq = new HashMap<>();
        freq.put(0,1);
        int count =0; int prefixSum =0 ;
        for(int i=0;i<nums.length;i++)
        {
            prefixSum = prefixSum + nums[i] ;
            if(freq.containsKey(prefixSum-k))
            {
                count = count + freq.get(prefixSum-k);
            }
            freq.put(prefixSum,freq.getOrDefault(prefixSum,0)+1) ;

        }
        return count ;
    }
}