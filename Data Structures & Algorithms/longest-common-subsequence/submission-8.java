class Solution {
    public int long1(String s1,String s2,int i,int j,int [][] dp)
    {
        if(i>=s1.length()||j>=s2.length())
        return 0;
        else if(dp[i][j]!=-1) 
        return dp[i][j];
        int x=0; int y =0;
        if(s1.charAt(i)==s2.charAt(j))
        x= long1(s1,s2,i+1,j+1,dp)+1;

        else 
        y = Math.max(long1(s1,s2,i,j+1,dp),long1(s1,s2,i+1,j,dp));

        dp[i][j]= Math.max(x,y);
        return dp[i][j];

    }
    public int longestCommonSubsequence(String s1, String s2) {
        if(s1.length()==0||s2.length()==0)
        return 0 ;
        int [][] dp = new int [s1.length()][s2.length()] ;
        for(int i=0;i<s1.length();i++)
        Arrays.fill(dp[i],-1);
        return long1(s1,s2,0,0,dp);
    }
}
