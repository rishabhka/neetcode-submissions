class Solution {
    public int profit(int [] prices,int i,int buy,int [][] dp)
    {
        if(i>=prices.length)
        return 0;
        else if(dp[i][buy]!=-1)
        return dp[i][buy];

        if(buy==0)
        {
            dp[i][buy]= Math.max(profit(prices,i+1,buy,dp),profit(prices,i+1,1,dp)-prices[i]);
        }
        else
        {
           dp[i][buy]=  Math.max(profit(prices,i+1,buy,dp),profit(prices,i+2,0,dp)+prices[i]); 
        }
        return dp[i][buy];

    }
    public int maxProfit(int[] prices) {
        
        if(prices.length<2)
        return 0;
        int [][] dp = new int[prices.length][2] ;
        for(int i=0;i<prices.length;i++)
        Arrays.fill(dp[i],-1);
        // 0-> u can buy , 1 -> u can sell
        return profit(prices,0,0,dp);
    }
}
