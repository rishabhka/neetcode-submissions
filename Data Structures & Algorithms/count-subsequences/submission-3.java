class Solution {
    public int sub(String s,String t,int i,int j,int [][]  dp)
    {
        if(j==t.length()) return 1 ;
        else if(i==s.length()) return 0;
        else if(dp[i][j]!=-1) return dp[i][j];
        else
        {
            if(s.charAt(i)==t.charAt(j))
            {
                dp[i][j]= sub(s,t,i+1,j+1,dp) + sub(s,t,i+1,j,dp);
            }
            else
            dp[i][j]= sub(s,t,i+1,j,dp);
        }
        return dp[i][j];

    }
    public int numDistinct(String s, String t) {
        if(t.length()>s.length())
        return 0;
        int [][]  dp = new int [s.length()][t.length()];
        for(int i=0;i<s.length();i++)
        Arrays.fill(dp[i],-1);
        return sub(s,t,0,0,dp);
    
}
}