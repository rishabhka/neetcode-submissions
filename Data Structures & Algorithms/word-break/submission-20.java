class Solution {
    public boolean f(String s,int i,HashSet<String> set,Boolean [] dp)
    {
        if(i>=s.length())
        return true ;
        else if(dp[i]!=null)
        return dp[i];
        else
        {
            for(int j=i;j<=s.length();j++)
            {
                // System.out.println(s.substring(i,j));
                if(set.contains(s.substring(i,j))&&f(s,j,set,dp))
                {
                return true;
                }
            }
        }
        dp[i]= false;
        return dp[i];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordDict)
        set.add(word);
        Boolean [] dp = new Boolean [s.length()+1];
        
        return f(s,0,set,dp);
    }
}
