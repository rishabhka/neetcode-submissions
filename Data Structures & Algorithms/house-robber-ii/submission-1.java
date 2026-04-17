class Solution {
    public int f(int[] nums,int i, int [] dp)
    {
       if(i>=nums.length)
       return 0;
       if(dp[i]!=-1)
       return dp[i];
       else
       {
        int x = f(nums,i+1,dp);
        int y = f(nums,i+2,dp) + nums[i];
        dp[i] = Math.max(x,y);
        return dp[i];
       }
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0)
        return 0;
        if(n==1)
        return nums[0];
        else
        {
            int [] dp1 = new int [n];
            int [] dp2 = new int [n];
            Arrays.fill(dp1,-1);
            Arrays.fill(dp2,-1);
            int [] excludeFirst = Arrays.copyOfRange(nums,1,n);
            int [] includeFirst = Arrays.copyOfRange(nums,0,n-1);
            return Math.max(f(excludeFirst,0,dp1),f(includeFirst,0,dp2));
        }
    }
}
