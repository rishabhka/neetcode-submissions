class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] memo = new int [amount+1] ;
        Arrays.fill(memo,Integer.MAX_VALUE) ;
        memo[0] = 0;
        for(int i=0;i<coins.length;i++)
        {
            for(int j = coins[i] ;j<=amount;j++)
            {
                if(memo[j-coins[i]]==Integer.MAX_VALUE) continue ;
                memo[j] = Math.min(memo[j-coins[i]]+1 , memo[j] ) ;
            }
        }
        return memo[amount]==Integer.MAX_VALUE?-1:memo[amount] ;
    }
}
