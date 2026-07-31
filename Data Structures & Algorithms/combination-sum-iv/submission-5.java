class Solution {
    public int comb(int [] nums,int i,int target,int [][] dp)
    {
        if(target ==0) return 1 ;
        else if(i==nums.length||target<0) return 0;
        else if(dp[i][target]!=-1) return dp[i][target] ;
        dp[i][target]= comb(nums,0,target-nums[i],dp) + comb(nums,i+1,target,dp) ;
        return dp[i][target];
    }
    public int combinationSum4(int[] nums, int target) {
        int [][] dp = new int[nums.length+1][target+1] ;
        for(int i=0;i<nums.length;i++)
        Arrays.fill(dp[i],-1) ;
        return comb(nums,0,target,dp);
    }
}