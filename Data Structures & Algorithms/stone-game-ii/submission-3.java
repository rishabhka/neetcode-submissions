class Solution {
    public int f(int[] piles, int i, int m,int [][] dp) {
        if (i >= piles.length)
            return 0;
        else if(dp[i][m]!=-1)
        return dp[i][m] ;
        int sum = 0;
        int prev = Integer.MIN_VALUE/2;

        for (int j = i; j < i + 2 * m && j < piles.length; j++) {
            sum += piles[j];
            prev = Math.max(prev, sum - f(piles, j + 1, Math.max(j - i + 1, m),dp));
        }

        dp[i][m]= prev;
        return dp[i][m];
    }

    public int stoneGameII(int[] piles) {
        int total = 0;
        for (int x : piles) total += x;
        int [][] dp = new int[piles.length+1][piles.length+1] ;
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);

        int diff = f(piles, 0, 1,dp);

        return (total + diff) / 2;   
    }
}