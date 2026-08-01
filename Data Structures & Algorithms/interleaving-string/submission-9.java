class Solution {
    public boolean check(String s1, String s2, String s3,int i,int j,Boolean[][] dp) 
    {
        if(i+j==s3.length()) return true ;
        else if(i<s1.length()&&j<s2.length()&&dp[i][j]!=null) return dp[i][j] ;
        else
        {
            Boolean res = false ;
            if(i<s1.length()&&s1.charAt(i)==s3.charAt(i+j))
            res= check(s1,s2,s3,i+1,j,dp) ;
            if (!res&&j<s2.length()&&s2.charAt(j)==s3.charAt(i+j))
            res= check(s1,s2,s3,i,j+1,dp) ;
            dp[i][j] =res ;
            return dp[i][j] ;
        }

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s2.length()+s1.length()) return false ;
        Boolean [][] dp = new Boolean [s1.length()+1][s2.length()+1] ;
        return check(s1,s2,s3,0,0,dp) ;
    }
}
