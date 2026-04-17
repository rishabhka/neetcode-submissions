class Solution {
    int min_coin = Integer.MAX_VALUE ;
    public void f(int[] coins,int i,int amount,int coin)
    {
        if(amount ==0)
        {
            min_coin = Math.min(min_coin,coin);
        }  
        else if(i>=coins.length||amount<0)
        return ;
        else 
        {
            f(coins,i,amount-coins[i],coin+1);
            f(coins,i+1,amount,coin) ;
            return;
        }

    }
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0||amount ==0)
        return 0;
        f(coins,0,amount,0);

        return min_coin == Integer.MAX_VALUE ? -1 : min_coin ;
    }
}
