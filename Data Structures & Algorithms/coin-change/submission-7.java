class Solution {
    public int minCoins(int[] coins,int amount,int i, int sum)
    {
        if(i>=coins.length||sum>amount)
        return Integer.MAX_VALUE/2 ;
        else if(sum==amount)
        {
            return 0;
        }
        else 
        return Math.min(minCoins(coins,amount,i,sum+coins[i])+1,minCoins(coins,amount,i+1,sum));

    }
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
        return 0;
        else if(coins.length==0)
        return -1;
        else 
        {
            int minCoins = minCoins(coins,amount,0,0);
            return minCoins==Integer.MAX_VALUE/2?-1:minCoins;
        } 
    }
}
