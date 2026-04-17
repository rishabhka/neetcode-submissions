class Solution {
    public boolean sub(char [] s,int i,int j,int k, Boolean [][] dp)
    {
        if(i>=j)
        return true ;
        else if(dp[i][j]!=null)
        return dp[i][j] ;
        else
        {
            if(s[i]==s[j])
            dp[i][j] = sub(s,i+1,j-1,k,dp);
            else
            {
                if(k>0)
                dp[i][j] = sub(s,i+1,j,k-1,dp) || sub(s,i,j-1,k-1,dp) ;
                else dp[i][j] = false;
            } 
            return dp[i][j] ;        
        }
    }
    public boolean validPalindrome(String s) {
        char [] charAr = s.toCharArray();
        int j = s.length()-1;
        int i=0;
        Boolean [][] dp = new Boolean [j+2][j+2];
        // for(int i=0;i<j+2;j++)
        // Arrays.fill(dp[i],-1);
        return sub(charAr,i,j,1,dp);
        
    }
}