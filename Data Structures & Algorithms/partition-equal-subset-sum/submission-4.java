class Solution {
    public boolean f(int[] nums,int sum, int i, int target, Boolean [][] dp)
    {
        if(sum==target)
        return true ;
        else if(sum>target)
        return false ;
        else if(dp[i][sum]!=null)
        return dp[i][sum] ;
        else if(nums.length==i)
        {
            return false;
        }
        else 
        {
            dp[i][sum] =f(nums,sum+nums[i],i+1,target,dp) || f(nums,sum,i+1,target,dp);
            return dp[i][sum] ;
        }
    }
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i=0;i<nums.length;i++)
        sum = sum + nums[i];
        if(sum%2!=0)
        return false;
        sum = sum /2 ;
        Boolean [][] dp = new Boolean [nums.length+1][sum+1];
        return f(nums,0,0,sum,dp);
    }
}
