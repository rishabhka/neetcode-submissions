class Solution {
    public int f (int [] cost,int i,int [] dp)
    {
        if(i>=cost.length)
        return 0 ;

        if(dp[i]!=-1)
        return dp[i];
        
        dp[i]=  Math.min(f(cost,i+1,dp)+cost[i],f(cost,i+2,dp)+cost[i]);
        return dp[i];

    }
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==0)
        return 0;
        int [] dp = new int [cost.length+1];
        Arrays.fill(dp,-1);

        return Math.min(f(cost,0,dp),f(cost,1,dp));
    }
}
