class Solution {
    public int f(int [] piles,int i ,int j,int [][] dp)
    {
        if(i==j)
        return piles[j];
        else if(dp[i][j]!=-1)
        return dp[i][j] ;
        else
        {
            dp[i][j]= Math.max(piles[i]-f(piles,i+1,j,dp),piles[j]+f(piles,i,j-1,dp)) ;
            return dp[i][j] ;
        }
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length; 
        int [][] dp  = new int [n+1][n+1] ;
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);
        return f(piles,0,n-1,dp)>0?true:false ;
        
    }
}