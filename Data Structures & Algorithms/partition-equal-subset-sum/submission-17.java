class Solution {
    public boolean subsetSum(int[] nums,int i , int total,Boolean [][] dp)
    {
        if(i==nums.length&&total==0)
        return true ;
        else if(i==nums.length||total<0)
        return false;
        else if (dp[i][total]!=null) return dp[i][total] ;
        else
        {
            dp[i][total]= subsetSum(nums,i+1,total-nums[i],dp) ||
            subsetSum(nums,i+1,total,dp) ;
            return dp[i][total];
        } 

    }
    public boolean canPartition(int[] nums) {
        int total =0;
        for(int i=0;i<nums.length;i++)
        total = total + nums[i] ;
        if(total%2!=0) return false;
        total = total/2;
        Boolean [][] dp = new Boolean [nums.length][total+1] ;
        return subsetSum(nums,0,total,dp) ;
    }
}
