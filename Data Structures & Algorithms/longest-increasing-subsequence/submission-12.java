class Solution {
    public int maxLIS(int [] nums , int i , int prev,int [][] dp )
    {
        if(i>=nums.length) return 0;
        else if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        if (prev == -1 || nums[i] > nums[prev])
        dp[i][prev+1]= Math.max(maxLIS(nums,i+1,prev,dp),maxLIS(nums,i+1,i,dp)+1);
        else dp[i][prev+1]=  maxLIS(nums,i+1,prev,dp) ;
        return dp[i][prev+1];
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)
        return 0;
        int dp [][] = new int[nums.length+1][nums.length+2];
        for(int i=0;i<=nums.length;i++)
        Arrays.fill(dp[i],-1);
        return maxLIS(nums,0,-1,dp);
    }
}
