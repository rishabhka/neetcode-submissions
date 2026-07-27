class Solution { 
    int min = Integer.MAX_VALUE;
    public int  dfs(String s,int i,HashSet<String> set,int [] dp)
    {
        int n = s.length();
        if(i==n) {return 0;} 
        else if(dp[i]!=-1) return dp[i] ;
        else
        {
            int x = dfs(s,i+1,set,dp) +1 ; 
            for(int j=i;j<n;j++)
            {
            String sub = s.substring(i,j+1) ;  
            if(!set.contains(sub)) continue ;
            x = Math.min(dfs(s,j+1,set,dp),x) ;
            }
            dp[i]=x ;
            return dp[i] ;
        }
    }  
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        for(String str : dictionary) set.add(str);
        int [] dp = new int[s.length()] ;
        Arrays.fill(dp,-1);
        return dfs(s,0,set,dp);
    }
}