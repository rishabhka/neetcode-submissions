class Solution {



    public int coinChange(int[] coins, int amount) {

        if(amount==0)
        return 0;

        if(coins.length<1)
        return -1 ;
        int n = coins.length;
        int [] dp = new int [amount+1];
        Arrays.fill(dp,amount+2);
        dp[0]=0;
        for(int coin : coins)
        {
            for(int i=coin;i<=amount;i++)
            {
                dp[i] = Math.min(dp[i] , dp[i-coin]+1);
            }
        }
        if(dp[amount]>amount)
        return -1;
        return dp[amount];
    
        
    }
}