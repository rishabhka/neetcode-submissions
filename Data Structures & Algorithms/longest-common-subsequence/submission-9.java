class Solution {
    public int LCS(String s1,String s2,int i,int j,int [][] dp)
    {
        if(i==s1.length()||j==s2.length()) return 0;
        else if(dp[i][j]!=-1) return dp[i][j] ;
        else
        {
            if(s1.charAt(i)==s2.charAt(j)) 
            dp[i][j]= LCS(s1,s2,i+1,j+1,dp) + 1 ;
            else 
            dp[i][j]= Math.max(LCS(s1,s2,i,j+1,dp),LCS(s1,s2,i+1,j,dp)) ;
            return dp[i][j] ;
        }

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length()][text2.length()] ;
        for(int i=0;i<text1.length();i++)
        Arrays.fill(dp[i],-1) ;
        return LCS(text1,text2,0,0,dp) ;
    }
}
