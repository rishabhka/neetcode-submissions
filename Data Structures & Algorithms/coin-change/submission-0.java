class Solution {
    int min_coin = Integer.MAX_VALUE;
    public void f(int [] coins , int i , int amount,int coin_len)
    {
        if(i>=coins.length)
        return ;
        else if(amount<0)
        return ;
        else if (amount ==0)
        {
            if(min_coin>coin_len)
            min_coin = coin_len ;
        }
        else
        {
            f(coins,i,amount-coins[i],coin_len+1);
            f(coins,i+1,amount,coin_len);
        }
    }
    public int coinChange(int[] coins, int amount) {
        
        if(coins.length==0)
        return -1;
        else if(amount==0)
        return 0;
        else
        f(coins,0,amount,0);
        if(min_coin==Integer.MAX_VALUE)
        return -1;
        return min_coin;
    }
}
