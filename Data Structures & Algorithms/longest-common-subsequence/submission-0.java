class Solution {
    public int LCS(String text1,String text2,int i,int j, int [][] dp)
    {
      if(i == text1.length() || j == text2.length())
      return 0 ;
      else if(dp[i][j]!=-1)
      return dp[i][j];
      else
      {
        if(text1.charAt(i)==text2.charAt(j))
        dp[i][j] =  LCS(text1,text2,i+1,j+1,dp) + 1;
        else
        dp[i][j] = Math.max(LCS(text1,text2,i,j+1,dp),LCS(text1,text2,i+1,j,dp));

        return dp[i][j];
      }
      
    }
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0||text2.length()==0)
        return 0;
        else
        {
            int [][] dp = new int [text1.length()][text2.length()];
            for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
            return LCS(text1,text2,0,0,dp);
        }
    }
}