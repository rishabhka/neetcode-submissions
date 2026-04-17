class Solution {
    public int f(int [] nums , int i,int [] dp)
    {
        if(i>=nums.length)
        return 0;
        else if (dp[i]!=-1)
        return dp[i]; 
        else
        {
            dp[i] = Math.max(f(nums,i+1,dp),f(nums,i+2,dp)+nums[i]);
            return dp[i]; 
        }
        
    }
    public int rob(int[] nums) {
        int [] dp = new int [nums.length+1];
        Arrays.fill(dp,-1);
        return f(nums,0,dp);
    }
}
