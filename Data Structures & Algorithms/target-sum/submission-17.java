class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==0)
        return 0 ;
        int total = 0;
        for(int i=0;i<nums.length;i++)
        total = total + nums[i] ;
        target = target+total ;
        if(target%2!=0) return 0;
        target = target /2 ;
        int [] dp = new int [target+1];
        dp[0] = 1;
        for(int i=0;i<nums.length;i++)
        {
            for(int j = target;j>=nums[i];j--)
            {
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
