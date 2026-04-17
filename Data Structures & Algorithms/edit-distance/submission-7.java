class Solution {
    public int f(String word1, String word2,int m,int n,int i , int j,int [][] dp)
    {
        if(i==m)
        return n-j;
        else if(j==n)
        return m-i;
        else if(dp[i][j]!=-1)
        return dp[i][j] ;
        else
        {
            // System.out.println(word1.substring(i,m)+" "+word2.substring(j,n));
            if(word1.charAt(i)==word2.charAt(j))
            dp[i][j] = f(word1, word2,m,n,i+1 ,j+1,dp);
            else
            {
                dp[i][j] = Math.min(Math.min(f(word1,word2,m,n,i+1,j,dp),f(word1,word2,m,n,i+1,j+1,dp)),f(word1,word2,m,n,i,j+1,dp)) +1; 
            }
            return dp[i][j] ;
        }
        

    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(word1.equals(word2))
        return 0 ;
        int [][] dp = new int [m][n] ;
        for(int i=0;i<m;i++)
        Arrays.fill(dp[i],-1);
         return f(word1,word2,m,n,0,0,dp);
    }
}
