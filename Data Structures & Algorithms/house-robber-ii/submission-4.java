class Solution {
    public int f(int [] nums, int n ,int i,int [] dp)
    {
        if(i>=n)
        return 0 ;
        else if(dp[i]!=-1)
        return dp[i];
        else
        {
            dp[i] =  Math.max(f(nums,n,i+1,dp),f(nums,n,i+2,dp)+nums[i]);
            return dp[i];
        }
    }
    public int rob(int[] nums) {
        if(nums.length==0)
        return 0;
        else if(nums.length==1)
        return nums[0];
        int [] dp1 = new int [nums.length+1];
        Arrays.fill(dp1,-1);
        int [] dp2 = new int [nums.length+1];
        Arrays.fill(dp2,-1);
        return Math.max(f(nums,nums.length-1,0,dp1),f(nums,nums.length,1,dp2));
    }
}
