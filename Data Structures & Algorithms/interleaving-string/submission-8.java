class Solution {
    public boolean check(String s1, String s2, String s3,int i,int j,int k,Boolean[][][] dp) 
    {
        if(k==s3.length()) return true ;
        else if(i<s1.length()&&j<s2.length()&&dp[i][j][k]!=null) return dp[i][j][k] ;
        else
        {
            Boolean res = false ;
            if(i<s1.length()&&s1.charAt(i)==s3.charAt(k))
            res= check(s1,s2,s3,i+1,j,k+1,dp) ;
            if (!res&&j<s2.length()&&s2.charAt(j)==s3.charAt(k))
            res= check(s1,s2,s3,i,j+1,k+1,dp) ;
            dp[i][j][k] =res ;
            return dp[i][j][k] ;
        }

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s2.length()+s1.length()) return false ;
        Boolean [][][] dp = new Boolean [s1.length()+1][s2.length()+1][s3.length()+1] ;
        return check(s1,s2,s3,0,0,0,dp) ;
    }
}
