class Solution {
    public int minCost(int i ,int [] cost,int [] dp)
    {
        if(i>=cost.length)
        return 0;
        else if(dp[i]!=-1)
        return dp[i];
        int oneStep = minCost(i+1 ,cost,dp) + cost[i];
        int twoStep = minCost(i+2 ,cost,dp) + cost[i];
        dp[i]= Math.min(oneStep,twoStep);
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp []= new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(minCost(0,cost,dp),minCost(1,cost,dp));
    }
}
