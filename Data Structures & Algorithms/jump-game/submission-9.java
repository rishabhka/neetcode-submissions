class Solution {
    public boolean canJump(int[] nums) {
        Boolean [] dp = new Boolean[nums.length];
        dp[nums.length-1] = true ;
        int target = nums.length-1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(i+nums[i]>=target) 
            {
            dp[i] = true ;
            target = i;
            }
            else dp[i] = false;
        }
        // check(nums,dp,nums.length-1);
        return dp[0];
    }
}
