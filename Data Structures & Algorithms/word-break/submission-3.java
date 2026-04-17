class Solution {
    public boolean f(String s,int i,int j,HashSet<String> set,Boolean [] [] dp)
    {
        if(j>=s.length())
        return false ;
        else if(j==s.length()-1)
        {
            String sub = s.substring(i,j+1);
            if(set.contains(sub))
            return true ;
            else return false;
        }
        else if(dp[i][j]!=null)
        return dp[i][j] ;
        else
        {
            if(set.contains(s.substring(i,j+1)))
            {
                dp[i][j] = f(s,j+1,j+1,set,dp) || f(s,i,j+1,set,dp) ;
            }
            else dp[i][j]=  f(s,i,j+1,set,dp) ;
            return dp[i][j] ;
        }

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        Boolean [] [] dp = new Boolean [n+1][n+1];
        // Arrays.fill(dp[i],-1);
        for(String s1 : wordDict)
        set.add(s1);
        return f(s,0,0,set,dp);
    }
}
