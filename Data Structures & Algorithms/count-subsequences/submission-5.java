class Solution {
    public int numSeq(String s, String t,int i,int j,int [][] dp)
    {
        if(j==t.length()) return 1 ;
        else if(dp[i][j]!=-1) return  dp[i][j] ;
        else if(i==s.length()) return 0 ;
        else 
        {
            if(s.charAt(i)==t.charAt(j))
            dp[i][j]= numSeq(s,t,i+1,j,dp) + numSeq(s,t,i+1,j+1,dp) ;
            else
            dp[i][j]= numSeq(s,t,i+1,j,dp) ;
            return dp[i][j] ;
        }
    }
    public int numDistinct(String s, String t) {
        int [][] dp = new int [s.length()+1][t.length()+1] ;
        for(int i=0;i<s.length();i++)
        Arrays.fill(dp[i],-1) ;

        if(s.length()<t.length()) return 0 ;
        return numSeq(s,t,0,0,dp) ;
    }
}
