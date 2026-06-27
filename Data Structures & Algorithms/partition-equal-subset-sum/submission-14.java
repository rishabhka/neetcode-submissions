class Solution {
    public boolean check (int [] nums,int i,int sum,Boolean [][] dp)
    {
        if(i>=nums.length||sum<0) return false;
        else if(dp[i][sum]!=null) return dp[i][sum];
        else if(sum==0) return true ;
        dp[i][sum]= check (nums,i+1,sum,dp) || check (nums,i+1,sum-nums[i],dp);
        return dp[i][sum];

    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums) 
            sum = sum + num ;
        Boolean [][] dp = new Boolean [nums.length][sum/2+1];
        if(sum%2!=0) return false;
        else return check (nums,0,sum/2,dp);
    }
}
