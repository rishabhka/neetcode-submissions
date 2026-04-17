class Solution {
    public int f(int [] nums,int i,int prev, int [][] dp)
    {
        if(i>nums.length)
        return 0 ;
        else if(dp[i][prev]!=-1)
        return dp[i][prev] ;
        else
        {
            if(prev!=0&&nums[i-1]<=nums[prev-1]) // skip
            dp[i][prev]= f(nums,i+1,prev,dp);
            else
            dp[i][prev]= Math.max(f(nums,i+1,prev,dp) ,f(nums,i+1,i,dp)+1);
            return dp[i][prev] ; 
        }
        

    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1)
        return nums.length;
        int [][] dp = new int [nums.length+1][nums.length+1];
        for(int i=0;i<=nums.length;i++)
        Arrays.fill(dp[i],-1);
        return f(nums,1,0,dp) ;
    }
}
