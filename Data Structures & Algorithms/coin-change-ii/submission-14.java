class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0) return 1 ;
        int [] dp = new int [amount+1] ;
        for(int coin : coins)
        {
            if(coin<=amount)
            dp[coin] ++ ;
            for(int j = coin;j<=amount;j++)
            {
                dp[j] = dp[j-coin] + dp[j] ;
            }
        }
        return dp[amount] ;
    }
}
