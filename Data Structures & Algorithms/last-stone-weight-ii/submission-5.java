class Solution {
    public int dfs(int [] stones,int i,int sum1 ,int [][] dp,int total)
    {
        if(i==stones.length) {
            return Math.abs(total-2*sum1) ;
        }
        else if(dp[i][sum1]!=-1) return dp[i][sum1] ;
        else
        {
            dp[i][sum1]= Math.min(dfs(stones,i+1,sum1+stones[i],dp,total),dfs(stones,i+1,sum1,dp,total));
            return dp[i][sum1];
        }

    }
    public int lastStoneWeightII(int[] stones) {
        int sum = 0 ;
        for(int i=0;i<stones.length;i++) sum = stones[i]+sum ;
        int [][] dp = new int [stones.length][sum] ;
        for(int i=0;i<stones.length;i++)
        {
        Arrays.fill(dp[i],-1) ;
        }
        return dfs(stones,0,0,dp,sum) ;
    }
}