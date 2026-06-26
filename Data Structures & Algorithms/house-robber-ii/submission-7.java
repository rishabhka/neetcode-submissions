class Solution {
    public int profit(int i,int n,int [] nums,int [] dp)
    {
        if(i>=n) return 0;
        else if(dp[i]!=-1)
        return dp[i];
        dp[i]=Math.max(profit(i+1,n,nums,dp),profit(i+2,n,nums,dp)+nums[i]);
        return dp[i];
    }
    public int rob(int[] nums) {
        int [] dp = new int [nums.length+1];
        Arrays.fill(dp,-1);
        int [] dp2 = new int [nums.length+1];
        Arrays.fill(dp2,-1);
        return Math.max(profit(2,nums.length-1,nums,dp)+nums[0],profit(1,nums.length,nums,dp2));
    }
}
