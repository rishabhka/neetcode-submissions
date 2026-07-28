class Solution {
    public int dfs(String s,Set<String> set,int i,int [] memo)
    {   int n = s.length();
        if(i==s.length()) return 0 ;
        else if(memo[i]!=-1) return memo[i] ;
        else
        {
            int notTake = dfs(s,set,i+1,memo) +1  ; int take = Integer.MAX_VALUE ;
            for(int j=i;j<n;j++)
            {
                if(set.contains(s.substring(i,j+1)))
                take= Math.min(take,dfs(s,set,j+1,memo)) ;
            }
            memo[i]= Math.min(take,notTake) ;
            return memo[i] ;
        }

    }
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<dictionary.length;i++)
        set.add(dictionary[i]) ;
        int [] memo = new int [s.length()] ;
        Arrays.fill(memo,-1) ;
        return dfs(s,set,0,memo) ;
    }
}