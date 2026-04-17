class Solution {
    public int f(int [] prices,int i,int buy,int [][] dp)
    {
        if(i>=prices.length)
        return 0;
        else if(dp[i][buy]!=-1)
        return dp[i][buy];

        else
        {
            if(buy==1)
            {
                dp[i][buy]= Math.max(f(prices,i+1,0,dp)-prices[i],f(prices,i+1,buy,dp));
            }
            else
            dp[i][buy]= Math.max(f(prices,i+2,1,dp)+prices[i],f(prices,i+1,buy,dp));
            return dp[i][buy] ;
        }
    }
    public int maxProfit(int[] prices) {
        if(prices.length==0||prices.length==1)
        return 0 ;
        int [][] dp = new int[prices.length+1][2];
        for(int i=0;i<prices.length;i++)
        Arrays.fill(dp[i],-1);
        return f(prices,0,1,dp);
        
    }
}
