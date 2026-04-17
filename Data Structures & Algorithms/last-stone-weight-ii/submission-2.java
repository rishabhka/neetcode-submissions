class Solution {
    //sum1 -> which we will subs
    //other half
    public int f(int [] stones , int i, int sum1,int sum2,int [][] dp,int tot_sum)
    {
        if(i>=stones.length)
        return Math.abs(tot_sum-2*sum2);
        else if(dp[i][sum2]!=-1)
        return dp[i][sum2] ;
        else
        {
            dp[i][sum2] = Math.min (f(stones , i+1,sum1,sum2,dp,tot_sum) ,
        f(stones , i+1,sum1,sum2+stones[i],dp,tot_sum)) ;
        return dp[i][sum2] ;
        }

    }
    public int lastStoneWeightII(int[] stones) {
        int tot_sum =0 ;
        for(int stone:stones)
        tot_sum = tot_sum + stone;
        // tot_sum= tot_sum/2;
        int [][] dp = new int [stones.length+1][tot_sum+1] ;
        for(int i=0;i<=stones.length;i++)
        Arrays.fill(dp[i],-1);
        return f(stones , 0,0,0,dp,tot_sum);
    }
}