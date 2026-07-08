class Solution {
    public int aliceScore(int [] stoneValue,int i,int [] dp)
    {
        if(i>=stoneValue.length)
        return 0;
        else if(dp[i]!=-1) return dp[i] ;
        else
        {
            int take = Integer.MIN_VALUE; int curr =0;
            for(int k=i;k<i+3&&k<stoneValue.length;k++)
            {
                curr = curr + stoneValue[k];
                take = Math.max(take,curr-aliceScore(stoneValue,k+1,dp));
            }
            dp[i]= take; 
            return dp[i];
        }

    }
    public String stoneGameIII(int[] stoneValue) {
        int [] dp = new int[stoneValue.length] ;
        Arrays.fill(dp,-1);
        int score  = aliceScore(stoneValue,0,dp);
        if(score==0) return "Tie" ;
        return score>0?"Alice":"Bob";
    }
}