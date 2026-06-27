class Solution {
    public int dist(String word1,String word2,int i,int j,int [][] dp)
    {
        if(i==word1.length())
        return word2.length()-j ;
        else if(j==word2.length())
        return word1.length()-i ;
        else if(dp[i][j]!=-1)
        return dp[i][j] ;

        if(word1.charAt(i)==word2.charAt(j))
        dp[i][j]= dist(word1,word2,i+1,j+1,dp);
        else 
        dp[i][j]= Math.min(Math.min(dist(word1,word2,i,j+1,dp) , dist(word1,word2,i+1,j,dp))
,dist(word1,word2,i+1,j+1,dp))+1;
return dp[i][j];

    }
    public int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);
        return dist(word1,word2,0,0,dp);
    }
}
