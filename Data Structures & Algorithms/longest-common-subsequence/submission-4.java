// f(i,j) -> if(i==j) Math.max(f(i+1,j+1)+1,f(i+1,j),f(i,j+1))
    //   ->  not eq f(i+1,j) , f(i,j+1)

class Solution {
    public int f(String text1,String text2,int i,int j,int [][] dp)
    {
        if(i==text1.length()||j==text2.length())
        return 0 ;
        else if(dp[i][j]!=-1)
        return dp[i][j];
        else
        {
            if(text1.charAt(i)==text2.charAt(j))
            dp[i][j]= f(text1,text2,i+1,j+1,dp)+1;
            else 
            dp[i][j]= Math.max(f(text1,text2,i+1,j,dp),f(text1,text2,i,j+1,dp));
            return dp[i][j] ;
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0||text2.length()==0)
        return 0 ;
        int dp [][] = new int [text1.length()+1][text2.length()+1] ;
        for(int i=0;i<=text1.length();i++)
        Arrays.fill(dp[i],-1);
        return f(text1,text2,0,0,dp);
    }
}
