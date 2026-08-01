class Solution {
    public int isAliceWin(int [] piles,int i,int j,int chance,int [][][] dp) 
    {
        if(i>j) return 0 ;
        else if(dp[i][j][chance]!=-1) return dp[i][j][chance] ;
        else
        {
            if(chance==1)
            dp[i][j][chance]= Math.max(piles[i] - isAliceWin(piles,i+1,j,0,dp),
            piles[j] - isAliceWin(piles,i,j-1,0,dp) ) ;
            else
            dp[i][j][chance]= Math.max(piles[i] - isAliceWin(piles,i+1,j,1,dp),
            piles[j] - isAliceWin(piles,i,j-1,1,dp) ) ;
            return dp[i][j][chance] ;
        }

    }
    public boolean stoneGame(int[] piles) {
        // 1 - alice , 0 -> bob
        int [][][] dp = new int [piles.length][piles.length][2] ;
        for(int i=0;i<piles.length;i++)
        {
            for(int j=0;j<piles.length;j++)
        {
        Arrays.fill(dp[i][j],-1) ;
        }
        }
        return isAliceWin(piles,0,piles.length-1,1,dp)>0?true:false ;
    }
}