class Solution {
    //neetcode
    public Boolean rec(String s,int i,Set<String> set ,Boolean [] dp) 
    {
        if(i==s.length()) return true ;
        else if(dp[i]!=null) return dp[i] ;
        else
        {
            for(int j=i;j<s.length();j++)
            {
                if(set.contains(s.substring(i,j+1))&&rec(s,j+1,set,dp))
                {
                dp[i]= true ; return true ;
                }
            }
            dp[i]= false;
            return dp[i] ;
        }

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String w : wordDict) set.add(w) ;
        Boolean [] memo = new Boolean [s.length()] ;
        return rec(s,0,set,memo) ;
    }
}
