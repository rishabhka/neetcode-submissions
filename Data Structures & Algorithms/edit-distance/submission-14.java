class Solution {
    public int minRep(String w1, String w2,int i,int j,int [][] dp)
    {
        if(i==w1.length())
            return (w2.length()-j) ;

        if(j==w2.length())
            return (w1.length()-i) ;

        if(dp[i][j]!=-1) return dp[i][j]  ;   

        else
        {
            if(w1.charAt(i)==w2.charAt(j))
            dp[i][j]= minRep(w1,w2,i+1,j+1,dp) ;
            else
            dp[i][j]= Math.min(minRep(w1,w2,i+1,j,dp),Math.min(minRep(w1,w2,i+1,j+1,dp),(minRep(w1,w2,i,j+1,dp)))) +1 ;
            return dp[i][j];
        }

    }
    public int minDistance(String w1, String w2) {
        int [][] dp = new int [w1.length()+1][w2.length()+1] ;
        for(int i=0;i<=w1.length();i++)
        Arrays.fill(dp[i],-1) ;
        return minRep(w1,w2,0,0,dp) ;
    }
}
