class Solution {
    public int play(int [] stoneValue,int i,Boolean chance,int [][] dp) 
    {
        int p = chance==true?0:1 ;
        int n = stoneValue.length ;
        if(i>=stoneValue.length) return 0 ;
        else if(dp[i][p]!=-1) return dp[i][p] ;

            int stone = 0; int max = Integer.MIN_VALUE ;
            for(int j=i;j<n&&j<i+3;j++)
            {
                stone = stone + stoneValue[j] ;
                max= Math.max(max,stone - play(stoneValue,j+1,!chance,dp));
            }
            dp[i][p] =max;
            return dp[i][p] ;

    }
    public String stoneGameIII(int[] stoneValue) {
        // true = alice , false - bob
        int [][] dp = new int [stoneValue.length][2] ;
        for(int i=0;i<stoneValue.length;i++)
        Arrays.fill(dp[i],-1) ;
        int x = play(stoneValue,0,true,dp)  ;
        System.out.println(x) ;
        if(x>0) return "Alice" ;
        else if(x<0) return "Bob" ;
        else return "Tie" ;
    }
}