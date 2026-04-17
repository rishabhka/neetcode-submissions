class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int p = 0 , q = 0;
        int sum = 0;
        int min_len = Integer.MAX_VALUE ; 
        while(q<nums.length)
        { 
            sum = sum + nums[q] ;
            
            while(sum>=target&&p<=q)
            {
            if(q-p+1<min_len)
            {
                min_len = q-p+1;
            }
            sum = sum - nums[p] ;
            p++;
                
            }
            q++;       
        }
        return min_len==Integer.MAX_VALUE?0:min_len;
    }
}