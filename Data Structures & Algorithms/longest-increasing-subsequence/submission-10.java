class Solution {
    public int LIS(int [] nums , int i , int prev,int [][] dp)
    {
        if(i>=nums.length)
        return 0 ;
        else if(dp[i][prev+1]!=-1)
        return dp[i][prev+1] ;
        else if(prev==-1||nums[i]>nums[prev])
        return dp[i][prev+1] = Math.max(LIS(nums,i+1,prev,dp),LIS(nums,i+1,i,dp)+1);
        else dp[i][prev+1] = LIS(nums,i+1,prev,dp) ;
        return dp[i][prev+1] ;
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1)
        return nums.length ;
        int [][] dp = new int [nums.length+2][nums.length+2] ;
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);
        return LIS(nums,0,-1,dp) ;
    }
}
