class Solution {
    public int f(int[] coins,int amount,int [] dp)
    {
        if(amount ==0) return 0 ;
        else if(amount<0) return Integer.MAX_VALUE/2;
        else if(dp[amount]!=-1)
        return dp[amount];
        else
        {
            int count =Integer.MAX_VALUE/2;
            for(int j=0;j<coins.length;j++)
            {
                count =Math.min(count,f(coins,amount-coins[j],dp)+1);
            }
            dp[amount]= count ;
            return dp[amount];
        }
    }
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int [amount+1];
        Arrays.fill(dp,-1);
        int count = f(coins,amount,dp) ; 
        return count==Integer.MAX_VALUE/2?-1:count;
    }
}
