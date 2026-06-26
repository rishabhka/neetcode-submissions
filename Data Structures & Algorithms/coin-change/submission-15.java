class Solution {

    public int coinChange(int[] coins, int amount) {
        if(amount ==0 || coins.length==0)
        return 0;
        int [] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        dp[0] = 0;
        for(int coin:coins)
        {
            for(int i=coin;i<=amount;i++ )
            {
                dp[i] = Math.min(dp[i-coin] + 1,dp[i]); 
            }
        }
        for(int x : dp)
        System.out.println(x);
        return dp[amount]>amount?-1:dp[amount];
    }
}
