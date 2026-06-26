class Solution {
    public int minCoin(int [] coins,int i,int amount,int [][] dp)
    {
        if(amount == 0)
        return 0;
        else if(i>=coins.length||amount<0)
        return Integer.MAX_VALUE/2;
        else if(dp[i][amount]!=-1)
        return dp[i][amount];
        else
        {
            if(amount-coins[i]<0)
            dp[i][amount]= minCoin(coins,i+1,amount,dp);
            dp[i][amount]=  Math.min(minCoin(coins,i,amount-coins[i],dp)+1,
            minCoin(coins,i+1,amount,dp));
            return dp[i][amount];
        }
    }
    public int coinChange(int[] coins, int amount) {
        if(amount ==0 || coins.length==0)
        return 0;
        int [][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length;i++)
        Arrays.fill(dp[i],-1);
        int result = minCoin(coins,0,amount,dp);
        return result==Integer.MAX_VALUE/2?-1:result;
    }
}
