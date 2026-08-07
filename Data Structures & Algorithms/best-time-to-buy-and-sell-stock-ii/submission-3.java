class Solution {
    int profit(int [] prices,int i,int buy,int [][] memo)
    {
        if(i==prices.length) return 0 ;
        if(memo[i][buy]!=-1) return memo[i][buy] ;
        if(buy == 1)
        memo[i][buy]= Math.max(profit(prices,i+1,0,memo)-prices[i],profit(prices,i+1,buy,memo))  ;
        else
        memo[i][buy]= Math.max(profit(prices,i+1,1,memo)+prices[i],profit(prices,i+1,buy,memo))  ;
        return memo[i][buy] ;

    }
    public int maxProfit(int[] prices) {
        int [][] memo = new int [prices.length][2] ;
        for(int i=0;i<memo.length;i++)
        Arrays.fill(memo[i],-1) ;
        return profit(prices,0,1,memo) ;
    }
}