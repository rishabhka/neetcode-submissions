class Solution {
   public int path(int[][] matrix,int i,int j,int [][] dp) 
   {
    int [][] dirs = new int [][] {{-1,0},{0,-1},{1,0},{0,1}} ;
    if(dp[i][j]!=0) return dp[i][j] ;
    int max = 0;
    for(int [] dir : dirs)
        {
        int x = dir[0] + i ; int y = j + dir[1];
        if(x<0||y<0||x>=matrix.length||y>=matrix[0].length||matrix[i][j]>=matrix[x][y])
        continue ;
        max = Math.max(max,path(matrix,x,y,dp)+1) ;
        }
        dp[i][j]= max ;
        return dp[i][j] ;
   }
    public int longestIncreasingPath(int[][] matrix) {
        int [][] dp = new int [matrix.length][matrix[0].length] ; int max = 0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                max = Math.max(max,path(matrix,i,j,dp)) ;
            }
        }
        return max +1 ;
    }
}
