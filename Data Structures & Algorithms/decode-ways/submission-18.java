class Solution {
    public int dfs(String s,int i,int [] memo)
    {
        if(i==s.length()) return 1 ;
        else if(s.charAt(i)=='0') return 0;
        else if(memo[i]!=-1) return memo[i] ;
        else
        {
            int a = dfs(s,i+1,memo) ; // Take curr 
            int b =0 ;
            // Skip and take with next 
            if(i+1<s.length()&&Integer.parseInt(s.substring(i,i+2))<=26)
            {
            b = dfs(s,i+2,memo) ;
            }
            memo[i]= a + b ;
            return memo[i] ;
        }

    }
    public int numDecodings(String s) {
        int [] memo = new int [s.length()];
        Arrays.fill(memo,-1) ;
        return dfs(s,0,memo) ;
    }
}
