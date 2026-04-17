class Solution {
    public int LIS(int [] nums , int i , int prev_index, int [][] dp)
    {
        if(nums.length==i)
        return 0;
        if(dp[i][prev_index+1]!=-1)
        return dp[i][prev_index+1] ;
        else
        {
            int x = LIS(nums,i+1,prev_index,dp);
            int y = 0;
            if(prev_index == -1 || (nums[i]>nums[prev_index]))
            y = LIS(nums,i+1,i,dp) +1 ;
            int z = Math.max(x,y);
            dp[i][prev_index+1] = z;
            return dp[i][prev_index+1] ;
        }
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n<2)
        return n;
        else
        {
            int [][] dp = new int [n][n+1];
            for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
            return LIS(nums,0,-1,dp);
        }
        
    }
}