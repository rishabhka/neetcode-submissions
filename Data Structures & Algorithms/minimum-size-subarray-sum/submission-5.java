class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int p =0 ; int q = 0 ; int min = Integer.MAX_VALUE ; int sum =0 ;
        while(q<nums.length)
        {
            sum = sum + nums[q] ;
            while(sum>=target)
            {
                min = Math.min(min,q-p+1);
                sum = sum - nums[p];
                p++;
            }
            q++ ;
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}