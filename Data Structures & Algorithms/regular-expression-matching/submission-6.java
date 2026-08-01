class Solution {
    public boolean match(String s,String p,int i,int j,Boolean [] [] dp)
    {
        if(j==p.length()) return s.length()==i ;
        else if(s.length()==i) {
            if(j+1<p.length()&&p.charAt(j+1)=='*') dp[i][j]= match(s,p,i,j+2,dp) ;
            else dp[i][j]= false;
        }
        else if(dp[i][j]!=null) return dp[i][j] ;
        else if(j+1<p.length()&&p.charAt(j+1)=='*')
        {
            if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')
            dp[i][j]= match(s,p,i+1,j,dp) || match(s,p,i,j+2,dp) ;
            else
            dp[i][j]= match(s,p,i,j+2,dp) ;
            return dp[i][j];
        }    
        else
        {
            if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')
            dp[i][j]= match(s,p,i+1,j+1,dp) ;
            else dp[i][j]= false ;
        }
        return dp[i][j] ;
    }
    public boolean isMatch(String s, String p) {
        Boolean [][] dp = new Boolean [s.length()+1][p.length()+1];
        return match(s,p,0,0,dp) ;
    }
}
