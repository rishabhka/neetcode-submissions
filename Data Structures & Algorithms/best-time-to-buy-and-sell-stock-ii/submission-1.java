class Solution {
    public int f(int [] prices , int i , int buy,int [][] dp)
    {
        if(i>=prices.length)
        return 0;
        else if(dp[i][buy]!=-1)
        return dp[i][buy] ;
        else
        {
            if(buy==1)
            {
                dp[i][buy]= Math.max(f(prices , i+1 , 1,dp),f(prices , i+1 , 0,dp) - prices[i]);
            }
            else
            {
                dp[i][buy]= Math.max(f(prices , i+1 , 0,dp),f(prices , i+1 , 1,dp) + prices[i]); 
            }
            return dp[i][buy] ;

        }
    }
    public int maxProfit(int[] prices) {
        int [][] dp = new int [prices.length+1][2] ;
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);
        return f(prices , 0 , 1,dp);
    }
}