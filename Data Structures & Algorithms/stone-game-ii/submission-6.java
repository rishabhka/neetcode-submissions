class Solution {
    public int maxAlice(int [] piles,int i,int m,int [][] dp)
    {
        if(i>=piles.length) return 0;
        else if(dp[i][m]!=-1) return dp[i][m] ;
        else
        {
            int count =0; int left =Integer.MIN_VALUE;
            for(int k=i;k<i+2*m&&k<piles.length;k++)
            {
                count = count + piles[k];
                left = Math.max(left,count - maxAlice(piles,k+1,Math.max(k-i+1,m),dp));
            }
            dp[i][m] = left;    
            return dp[i][m] ;
        }

    }
    public int stoneGameII(int[] piles) {
        int total = 0;
    for (int p : piles) total += p;
    int dp [][] = new int [piles.length][piles.length+1];
    for(int i=0;i<piles.length;i++)
    Arrays.fill(dp[i],-1);
    int advantage = maxAlice(piles, 0, 1,dp);
    return (total + advantage) / 2;   
        // return maxAlice(piles,0,1);
    }
}