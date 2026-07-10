class Solution {
    public int ways(int[] nums,int i,int sum ,int target,int [][] dp,int total)
    {
        if(i==nums.length&&sum==target)
        return 1;
        else if(i==nums.length) 
        return 0;
        else if(dp[i][sum+total]!=-1) return dp[i][sum+total] ;

        dp[i][sum+total]= ways(nums,i+1,sum+nums[i],target,dp,total) + ways(nums,i+1,sum-nums[i],target,dp,total);
        return dp[i][sum+total] ;

    }
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==0)
        return 0 ;
        int total = 0;
        for(int i=0;i<nums.length;i++)
        total = total + nums[i] ;
        int [][] dp = new int[nums.length][2*total+1];
        
        for(int i=0;i<nums.length;i++)
        Arrays.fill(dp[i],-1);
        
        return ways(nums,0,0,target,dp,total);
    }
}
