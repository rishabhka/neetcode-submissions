//[1,2,7,2]
class Solution {
    public int f(int [] piles,int i,int j,int aliceChance,int [][][] dp)
    {
        if(i>j) return 0;
        else if(dp[i][j][aliceChance]!=-1)
        return dp[i][j][aliceChance];
        else
        {
            int max =0;
            if(aliceChance==0)
            {
            max = Math.max(f(piles,i+1,j,1,dp)+piles[i],
            f(piles,i,j-1,1,dp)+piles[j]) ;
            }
            else
            {
            max = Math.max(f(piles,i+1,j,0,dp )-piles[i],
            f(piles,i,j-1,0,dp )-piles[j]) ;
            }
            dp[i][j][aliceChance]= max;
            return dp[i][j][aliceChance];
        }
    }
    public boolean stoneGame(int[] piles) {
        int aliceChance  = 0 ;
        int [][][] dp = new int [piles.length][piles.length][2];
        for(int i=0;i<piles.length;i++){
            for(int j=0;j<piles.length;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        int max = f(piles,0,piles.length-1,aliceChance,dp);
        
        return max>0?true:false;
    }
}