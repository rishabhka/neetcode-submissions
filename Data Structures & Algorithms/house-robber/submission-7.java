class Solution {
    public int houseRob(int [] nums,int i,int [] dp)
    {
        if(i>=nums.length) return 0;
        else if(dp[i]!=-1) return dp[i] ;
        else
        {
            dp[i]=  Math.max(houseRob(nums,i+1,dp),houseRob(nums,i+2,dp)+nums[i]) ;
            return dp[i] ;
        }
    }
    public int rob(int[] nums) {
        int [] dp = new int [nums.length] ;
        Arrays.fill(dp,-1) ;
        return houseRob(nums,0,dp) ;
    }
}
