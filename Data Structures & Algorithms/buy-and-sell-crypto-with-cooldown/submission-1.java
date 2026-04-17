class Solution {
    public int f(int [] prices,int i,boolean buy)
    {
        if(i>=prices.length)
        return 0;
        else
        {
            if(buy)
            {
                return Math.max(f(prices,i+1,false)-prices[i],f(prices,i+1,buy));
            }
            else
            return Math.max(f(prices,i+2,true)+prices[i],f(prices,i+1,buy));
        }
    }
    public int maxProfit(int[] prices) {
        if(prices.length==0||prices.length==1)
        return 0 ;
        return f(prices,0,true);
        
    }
}
