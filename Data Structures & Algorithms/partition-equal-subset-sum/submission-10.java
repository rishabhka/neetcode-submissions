class Solution {
    public boolean f(int [] nums ,int i , int sum,int curr,Boolean [][] dp)
    {
        if(i>=nums.length||curr>sum)
        return false ;
        else if(dp[i][curr]!=null)
        return dp[i][curr] ;
        else if(sum == curr)
        return true ;
        else 
        {
        dp[i][curr] = f(nums,i+1,sum,curr+nums[i],dp) || f(nums,i+1,sum,curr,dp) ;
        return dp[i][curr];
        }
    }
    public boolean canPartition(int[] nums) {
        // if(nums.length%2!=0)
        // return false;
        int sum =0 ;
        for(int num:nums)
        sum = sum + num ;
        if(sum%2!=0)
        return false;
        Boolean [][] dp = new Boolean [nums.length][sum+1] ;
        sum = sum /2 ;
        
        return f(nums,0,sum , 0,dp );
    }
}
