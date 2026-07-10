class Solution {
    public boolean f(String s1,String s2,String s3,int i,int j,Boolean [][] dp)
    {
        if(i==s1.length()&&j==s2.length()&&(i+j)==s3.length())
        return true ;
        else if(i>=s1.length())
        {
            if(s2.substring(j,s2.length()).equals(s3.substring(i+j,s3.length())))
            return true ;
            else return false;
        }
        else if(j>=s2.length())
        {
            if(s1.substring(i,s1.length()).equals(s3.substring(i+j,s3.length())))
            return true ;
            else return false;
        }
        else if(dp[i][j]!=null)
        return dp[i][j] ;
        else
        {
            if(s1.charAt(i)==s3.charAt(i+j)&&s2.charAt(j)==s3.charAt(i+j))
            dp[i][j]= f(s1,s2,s3,i+1,j,dp) || f(s1,s2,s3,i,j+1,dp) ;
            else if(s1.charAt(i)==s3.charAt(i+j))
            dp[i][j]= f(s1,s2,s3,i+1,j,dp);
            else if(s2.charAt(j)==s3.charAt(i+j))
            dp[i][j]= f(s1,s2,s3,i,j+1,dp) ;
            else dp[i][j]= false;
            return dp[i][j];
        }

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
        return false;
        Boolean [][] dp = new Boolean [s1.length()][s2.length()];
        return f(s1,s2,s3,0,0,dp);

    }
}
