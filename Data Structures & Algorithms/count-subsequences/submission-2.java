class Solution {
    public int num(String s,String t ,int i,int j,int [][] dp)
    {
        if(i>s.length())
        return 0;
        else if(j==t.length())
        return 1;
        if(i==s.length())
        return 0;
        else if(dp[i][j]!=-1)
        return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
        dp[i][j]= num(s,t,i+1,j+1,dp) +  num(s,t,i+1,j,dp) ;
        else dp[i][j]= num(s,t,i+1,j,dp) ;
        return dp[i][j];


    }
    public int numDistinct(String s, String t) {
        if(t.length()>s.length())
        return 0;
        int [][] dp = new int[s.length()][t.length()];
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);
        return num(s,t,0,0,dp);
    }
}
