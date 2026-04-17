class Solution {
    public int maxProfit(int[] prices) {
        int sell = prices[prices.length-1] ;
        int max = 0;
        for(int i=prices.length-1;i>=0;i--)
        {
            if(sell-prices[i]>max)
            max = sell-prices[i] ;
            if(prices[i]>sell)
            sell = prices[i] ;
        }
        return max ;
    }
}
