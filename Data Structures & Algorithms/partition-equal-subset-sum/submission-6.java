class Solution {
    public boolean f(int [] nums,int i , int sum,Boolean [][] dp)
    {
        if(sum ==0)
        return true ;
        if(i>=nums.length||sum<0)
        return false;
        else if(dp[i][sum]!=null)
        return dp[i][sum];
        else
        {
        dp[i][sum]= f(nums,i+1 , sum-nums[i],dp) || f(nums,i+1 , sum,dp) ;
        return dp[i][sum];
        }
    }
    public boolean canPartition(int[] nums) {
        int sum =0 ;
        for(int i=0;i<nums.length;i++)
        sum = sum + nums[i];
        if(sum%2!=0)
        return false ;
        sum = sum /2 ;

        Boolean [][] dp = new Boolean [nums.length+1][sum+1];
        // Arrays.fill(dp,-1);
        return f(nums,0 , sum,dp);
    }
}
