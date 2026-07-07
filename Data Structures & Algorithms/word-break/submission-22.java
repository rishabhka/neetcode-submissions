class Solution {
    public boolean f(String s,int i ,Set<String> set,Boolean [] dp)
    {
        if(i==s.length()) return true;
        else if(dp[i]!=null) return dp[i];
        // boolean flag = false;
        dp[i]=false;
        for(int j=i;j<s.length();j++)
        {
            if(set.contains(s.substring(i,j+1)))
            dp[i] = dp[i] || f(s,j+1,set,dp);
            if(dp[i])
            return dp[i];
        }
        return dp[i];

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0)
        return true ;
        else if(wordDict.size()==0)
        return true ;
        Boolean [] dp = new Boolean[s.length()]; 
        Set<String> set = new HashSet<>();
        for(String str : wordDict)
        set.add(str);
        // set.add(s);
        return f(s,0,set,dp);
    }
}
