class Solution {
    public int numCoins(int amount,int [] coins,int i,int [][] dp)
    {
        if(amount==0)
        return 1;
        else if(i>=coins.length||amount<0)
        return 0;
        else if(dp[i][amount]!=-1)
        return dp[i][amount];
        

        dp[i][amount]= numCoins(amount-coins[i],coins,i,dp) + numCoins(amount,coins,i+1,dp) ;
        return dp[i][amount];

    }
    public int change(int amount, int[] coins) {
        if(amount ==0|| coins.length==0)
        return 1;
        int [][] dp = new int[coins.length+1][amount+1] ;
        for(int i=0;i<coins.length;i++)
        Arrays.fill(dp[i],-1);
        return numCoins(amount,coins,0,dp);
    }
}
