class Solution {
    public boolean f(String s,int i,HashSet<String> set,Boolean [] dp)
    {
        if(i==s.length())
        return true;
        else if(i>s.length())
        return false;
        else if(dp[i]!=null)
        return dp[i];
        else
        {
        for(int j=i;j<s.length();j++)
        { 
            String sub = s.substring(i,j+1);
            //System.out.println(i+" "+j+ " "+sub);
            if(set.contains(sub))
            {
                if( f(s,j+1,set,dp) )
                {
                dp[i] = true;
                return true;
                }
            }
        }
        }
        dp[i]= false;
        return dp[i] ; 

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        if(n<1)
        return false;
        else
        {
            HashSet<String> set = new HashSet<>();
            Boolean [] visited = new Boolean [n+1] ;
            for(String word :wordDict )
            set.add(word);
            return f(s,0,set,visited);
        }
    }
}
