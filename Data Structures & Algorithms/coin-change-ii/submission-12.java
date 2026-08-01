class Solution {
    public int f(int amount,int [] coins,int i,int [][] dp) 
    {
        if(amount<0) return 0 ;
        else if(coins.length==i) { if(amount==0)return 1; else return 0 ; } 
        else if(dp[i][amount]!=-1) return dp[i][amount] ;
        else
        {
        dp[i][amount]= f(amount-coins[i],coins,i,dp) + f(amount,coins,i+1,dp) ;
        return dp[i][amount] ;
        }
        

    }
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length][amount+1]; 
        for(int i=0;i<coins.length;i++)
        Arrays.fill(dp[i],-1) ;
        return f(amount,coins,0,dp) ;
    }
}
