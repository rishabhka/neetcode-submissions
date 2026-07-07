class Solution {
    public int decodings(String s,int i,int [] dp)
    {
        if(i>=s.length()) return 1 ;
        else if(s.charAt(i)=='0') return 0;
        else if(dp[i]!=-1)
        return dp[i] ;
        else
        {
            int x = decodings(s,i+1,dp) ; int y= 0;
            if(i+2<=s.length()&&Integer.parseInt(s.substring(i,i+2))<=26)
            y = decodings(s,i+2,dp) ;
            dp[i]= x + y;
            return dp[i];
        }

    }
    public int numDecodings(String s) {
        int [] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return decodings(s,0,dp);
    }
}
