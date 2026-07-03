class Solution {
    public int maxSubArray(int[] nums) {
        int local =0;
        int global = Integer.MIN_VALUE ;
        for(int i=0;i<nums.length;i++)
        {
            local = local +nums[i] ;
            if(local>global)
            global = local;
            if(local<0) local =0;
        }
        return global;
    }
    
}
