class Solution {
    public int maxAlice(int [] piles,int i,int m,int [][] dp)
    {
        if(i==piles.length) return 0;
        else if(dp[i][m]!=-1) return dp[i][m] ;
        else
        {
            int max = Integer.MIN_VALUE ; int pile = 0;
            for(int X=1;X<=2*m&&i+X-1<piles.length;X++)
            {
                pile = piles[i+X-1] + pile ;
                max = Math.max(max,pile -maxAlice(piles,i+X,Math.max(m,X),dp)) ;
            }
            dp[i][m]= max ;
            return dp[i][m] ;
        }

    }
    public int stoneGameII(int[] piles) {
        int total = 0;
        int [][] dp = new int[piles.length+1][piles.length+1] ;
        for(int i=0;i<piles.length;i++)
        Arrays.fill(dp[i],-1) ;
        for(int i=0;i<piles.length;i++)
        total = total + piles[i] ;
        return (total+ maxAlice(piles,0,1,dp) )/2;
    }
}