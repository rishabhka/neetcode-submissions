class Solution {
    public boolean backtrack(String s,List<String> wordDict,int i,Boolean [] dp)
    {
        if(i==s.length())
        return true ;

        if(dp[i]!=null)
        return dp[i] ;

        for(int j=0;j<wordDict.size();j++)
        {
            String word = wordDict.get(j);
            if(i+word.length()>s.length())
            continue ;
            String temp = s.substring(i,i+word.length());
            if(temp.equals(word))
            if(backtrack(s,wordDict,i+word.length(),dp))
            {
            dp[i]= true ;
            return dp[i] ;
            }
        }
        dp[i] = false;
        return dp[i] ;

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean [] dp = new Boolean[s.length()];
        return backtrack(s,wordDict,0,dp);
    }
}
