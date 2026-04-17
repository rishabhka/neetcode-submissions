class Solution {
    public int max_comb(int [] coins,int i,int amount,int [][] dp)
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
            dp[i][amount]= max_comb(coins,i+1,amount,dp)+max_comb(coins,i,amount-coins[i],dp);
            return dp[i][amount];
            // return (max_comb(coins,i+1,amount)+max_comb(coins,i,amount-coins[i]));
        }

    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        if(amount == 0)
        return 1;
        else 
        {
          int [][] dp = new int[n+1][amount+1] ; 
          for(int i=0;i<=n;i++)
          Arrays.fill(dp[i],-1);
          int x=  max_comb(coins,0,amount,dp);
          return x;
        }
    }
}
