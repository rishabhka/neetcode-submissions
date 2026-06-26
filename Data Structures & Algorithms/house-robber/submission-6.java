class Solution {
    public int maxCost(int [] nums,int i,int [] dp) 
    {
        if(i<0)
        return 0;
        else if(dp[i]!=-1)
        return dp[i];
        dp[i]=Math.max(maxCost(nums,i-1,dp),maxCost(nums,i-2,dp)+nums[i]);
        return dp[i]; 

    }
    public int rob(int[] nums) {
        int [] dp = new int [nums.length];
        Arrays.fill(dp,-1);
        return maxCost(nums,nums.length-1,dp);
    }
}
