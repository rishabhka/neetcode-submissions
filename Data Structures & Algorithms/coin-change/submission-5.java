class Solution {
    public int f(int [] coins,int amount,int i,int curr_len)
    {
        if(amount<0)
        return Integer.MAX_VALUE;
        else if(amount==0)
        return curr_len;
        else if(coins.length<=i)
        return Integer.MAX_VALUE;
        else
        {
          return Math.min(f(coins,amount,i+1,curr_len),f(coins,amount-coins[i],i,curr_len+1));
        }

    }
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
        return 0;
        int x = f(coins,amount,0,0);
        return x==Integer.MAX_VALUE?-1:x;
    }
}
