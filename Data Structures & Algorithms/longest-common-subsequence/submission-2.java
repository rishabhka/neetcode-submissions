class Solution {
    public int lcs(String s1,String s2,int i,int j,int dp [][])
    {
        if(i>=s1.length()||j>=s2.length())
        return 0;
        else if(dp[i][j]!=-1)
        return dp[i][j] ;
        else
        {
            if(s1.charAt(i)==s2.charAt(j))
            dp[i][j]= lcs(s1,s2,i+1,j+1,dp) + 1 ;
            else
            dp[i][j] = Math.max(lcs(s1,s2,i,j+1,dp) ,  lcs(s1,s2,i+1,j,dp)) ;
            return dp[i][j] ;
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0||text2.length()==0)
        return 0;
        int dp [][] = new int [text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++)
        Arrays.fill(dp[i],-1);
        return lcs(text1,text2,0,0,dp);
    }
}
