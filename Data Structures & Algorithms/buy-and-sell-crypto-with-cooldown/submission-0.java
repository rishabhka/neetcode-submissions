class Solution {
    public int max_profit(int [] prices,int i ,int isBuy , int [][] dp )
    {
        if(prices.length<=i)
        return 0;
        else if(dp[i][isBuy]!=-1)
        return dp[i][isBuy] ;
        else
        {
            if(isBuy==0)
            {
             dp[i][isBuy] = Math.max ( max_profit(prices,i+2,1,dp)+prices[i] ,
                    max_profit(prices,i+1,isBuy,dp) );
            }
            else
            {
                // System.out.println(i);
                dp[i][isBuy] = Math.max ( max_profit(prices,i+1,0,dp) - prices[i] ,
                    max_profit(prices,i+1,isBuy,dp) );
            }
            return dp[i][isBuy];
        }


    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if(n<=0)
        return 0;
        else if(n==1)
        return 0;
        else
        {
            int [][] dp = new int [n+1][2] ;
            for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],-1);
            return max_profit(prices,0,1,dp);
        }

    }
}
