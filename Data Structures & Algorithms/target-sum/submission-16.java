class Solution {
    public int ways(int[] nums,int i,int target,int [][] dp)
    {
        if(i<0&&target==0)
        return 1;
        else if(i<0||target<0) 
        return 0;
        else if(dp[i][target]!=-1) return dp[i][target] ;

        dp[i][target]= ways(nums,i-1,target-nums[i],dp) + ways(nums,i-1,target,dp);
        return dp[i][target] ;

    }
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==0)
        return 0 ;
        int total = 0;
        for(int i=0;i<nums.length;i++)
        total = total + nums[i] ;
        target = target+total ;
        if(target%2!=0) return 0;
        target = target /2 ;
        int [][] dp = new int[nums.length][2*target+1];
        
        for(int i=0;i<nums.length;i++)
        Arrays.fill(dp[i],-1);
        
        return ways(nums,nums.length-1,target,dp);
    }
}
