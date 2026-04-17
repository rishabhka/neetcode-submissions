class Solution {
    int counter = 0;
    public int f(String s,int i ,String subs, int [] dp)
    {
        int n = s.length();
        if(!subs.equals("")&&Integer.parseInt(subs)>26)
        return 0 ;
        if(i==s.length())
        return 1;
        if (i>s.length())
        return 0;
        else if(s.charAt(i)=='0')
        return 0;
        else if(dp[i]!=-1)
        return dp[i];
        else
        {
            int x  = 0 ;
            if(i+1<=n)
            {
            x = x + f( s, i + 1 , s.substring(i,i+1),dp ) ;
            }
            if(i+2<=n)
            x= x + f( s, i + 2, s.substring(i,i+2),dp );
            dp[i] = x ;
        return x;
        }
    }
    public int numDecodings(String s) {
        int n = s.length();
        if(n<1)
        return 0;
        else if(s.charAt(0)=='0')
        return 0;
        else
        {
          int [] dp = new int [n] ;
          Arrays.fill(dp,-1);
          return f(s,0,"",dp);
        }
        
    }
}
