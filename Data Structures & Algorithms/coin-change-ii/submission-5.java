class Solution {
    public int f(int[] coins,int amount,int i,int [][] dp)
    {
        if(amount==0)
        return 1;
        else if(amount<0)
        return 0;
        else if(i>=coins.length)
        return 0; 
        else if(dp[i][amount]!=-1)
        return dp[i][amount] ;
        else
        {
        dp[i][amount] = f(coins,amount-coins[i],i,dp) + f(coins,amount,i+1,dp) ;
        return dp[i][amount] ;
        }
    }
    public int change(int amount, int[] coins) {
        if(amount ==0 || coins.length ==0 )
        return 1 ;
        int [][] dp = new int [coins.length+1][amount+1];
        for(int i=0;i<coins.length;i++)
        Arrays.fill(dp[i],-1);
        return f(coins,amount,0,dp);
    }
}
