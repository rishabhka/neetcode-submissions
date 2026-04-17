class Solution {
    public int maxCost(int [] nums,int i,int [] dp)
    {
        if(i>=nums.length)
        return 0 ;
        else if(dp[i]!=-1)
        return dp[i] ;
        else
        {
            dp[i] = Math.max(maxCost(nums,i+1,dp),maxCost(nums,i+2,dp)+nums[i]);
            return dp[i];
        }

    }
    public int rob(int[] nums) {
        if(nums.length==0)
        return 0 ;
        int [] dp = new int [nums.length+1];
        Arrays.fill(dp,-1);
        return maxCost(nums,0,dp);
    }
}
