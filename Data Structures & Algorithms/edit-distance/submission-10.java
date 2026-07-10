class Solution {
    // niot equal - replace , deleete 
    public int f(String word1, String word2,int i ,int j,int [][] dp)
    {
        if(i>=word1.length()) return word2.length()-j;
        else if (j>=word2.length()) return word1.length()-i ;
        else if(dp[i][j]!=-1) return dp[i][j];
        // else if(j>)
        else
        {
            if(word1.charAt(i)==word2.charAt(j))
            dp[i][j]= f(word1,word2,i+1,j+1,dp);
            else
            {
                dp[i][j]= Math.min(Math.min(f(word1,word2,i+1,j,dp),f(word1,word2,i+1,j+1,dp)),
                f(word1,word2,i,j+1,dp))+1;
            }
            return dp[i][j];
        }

    }
    public int minDistance(String word1, String word2) {
        int [][] dp = new int [word1.length()][word2.length()] ;
        for(int i=0;i<word1.length();i++)
        Arrays.fill(dp[i],-1);
        return f(word1,word2,0,0,dp);
    }
}
