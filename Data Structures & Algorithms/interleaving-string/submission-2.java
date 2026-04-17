class Solution {
    public boolean f(String s1,String s2,String s3,int i,int j,Boolean [][] dp)
    {
        if(i+j==s3.length())
        return true ;
        else if(dp[i][j]!=null)
        return dp[i][j];
        else
        {
            boolean x = false , y = false ;
            if(i<s1.length())
            {
            if(s1.charAt(i)==s3.charAt(i+j))
            x = f( s1, s2, s3, i+1, j,dp);
            }
            if(j<s2.length())
            {
            if(s2.charAt(j)==s3.charAt(i+j))
            y = f( s1, s2, s3, i, j+1,dp);
            }
            dp[i][j] = x || y;
            return dp[i][j] ;
        }

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
        return false ;
        Boolean [][] dp = new Boolean [s1.length()+1][s2.length()+1] ;
        // for(int i=0;i<s1.lenght();i++)
        // Arrays.fill(dp[i],-1);
        return f(s1,s2,s3,0,0,dp);
    }
}
