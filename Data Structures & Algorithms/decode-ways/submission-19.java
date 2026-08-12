class Solution {
    public int dfs(String s,int i,int [] memo)
    {
        if(i==s.length()) return 1 ;
        else if(s.charAt(i)=='0') return 0;
        else if(memo[i]!=-1) return memo[i] ;
        else
        {
            int count =0 ; int sum =0 ;
            for(int j=i;j<s.length();j++)
            {
                sum = sum*10 + Integer.parseInt(s.charAt(j)+"") ;
                if(sum>26) break ;
                count = count + dfs(s,j+1,memo) ;
            }
            memo[i]= count ;
            return memo[i] ;
        }

    }
    public int numDecodings(String s) {
        int [] memo = new int [s.length()];
        Arrays.fill(memo,-1) ;
        return dfs(s,0,memo) ;
    }
}
