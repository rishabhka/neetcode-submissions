class Solution {
    public int f(int []  prices,int i,boolean buy,int [][] dp)
    {
        int flag =0;
        if(buy)
        flag = 1;
        if(i>=prices.length)
        return 0;
        else if(dp[i][flag]!=-1)
        return dp[i][flag];
        else
        {
            if(buy) // then eitehr sell it move to next -> 1
            dp[i][flag]= Math.max(f(prices,i+2,false,dp)+prices[i], f(prices,i+1,true,dp)) ;
            else // either buy or skip
            {
                dp[i][flag]= Math.max(f(prices,i+1,true,dp) - prices[i] ,f(prices,i+1,false,dp));
            }
            return dp[i][flag];
        }
    }
    public int maxProfit(int[] prices) {
        if(prices.length==0)
        return 0;
        int [][] dp = new int [prices.length][2] ;
        for(int i=0;i<prices.length;i++)
        Arrays.fill(dp[i],-1);
        return f(prices,0,false,dp);
    }
}
