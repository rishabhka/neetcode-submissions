class Solution {
    public int f(int []  prices,int i,boolean buy)
    {
        if(i>=prices.length)
        return 0;
        else
        {
            if(buy) // then eitehr sell it move to next -> 1
            return Math.max(f(prices,i+2,false)+prices[i], f(prices,i+1,true)) ;
            else // either buy or skip
            {
                return Math.max(f(prices,i+1,true) - prices[i] ,f(prices,i+1,false));
            }
        }
    }
    public int maxProfit(int[] prices) {
        if(prices.length==0)
        return 0;
        else
        return f(prices,0,false);
    }
}
