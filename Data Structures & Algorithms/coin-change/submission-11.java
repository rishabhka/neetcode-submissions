class Solution {
    public int minCoin(int [] coins,int i,int amount)
    {
        if(amount == 0)
        return 0;
        else if(i>=coins.length)
        return Integer.MAX_VALUE/2;
        else
        {
            if(amount-coins[i]<0)
            return minCoin(coins,i+1,amount);
            return Math.min(minCoin(coins,i,amount-coins[i])+1,
            minCoin(coins,i+1,amount));
        }
    }
    public int coinChange(int[] coins, int amount) {
        if(amount ==0 || coins.length==0)
        return 0;
        return minCoin(coins,0,amount)==Integer.MAX_VALUE/2?-1:minCoin(coins,0,amount);
    }
}
