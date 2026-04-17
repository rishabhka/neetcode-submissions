class Solution {
    public boolean checkSubsum(int [] nums,int i ,int sum,Boolean [][] dp)
    {
        if(sum==0)
        return true; 
        if(nums.length==i||sum<0)
        return false;
        else if(dp[i][sum]!=null)
        return dp[i][sum];
        else
        {
            dp[i][sum] =  checkSubsum(nums,i+1,sum,dp) || checkSubsum(nums,i+1,sum-nums[i],dp) ;
            return dp[i][sum] ;
        }

    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++)
        sum = sum + nums[i];
        if(sum%2!=0)
        return false;
        else
        {
           Boolean [][] dp = new Boolean [n+1][sum+1] ;
            sum = sum /2 ;
            return checkSubsum(nums,0,sum,dp);
        }
    }
}
