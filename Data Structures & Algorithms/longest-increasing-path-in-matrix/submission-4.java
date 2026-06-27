class Solution {
    public int maxPath(int[][] matrix,int [][] dp,int i , int j,int prev)
    {
        if(i<0||j<0||i>=matrix.length||j>=matrix[0].length)
        return 0;
        else if(matrix[i][j]<=prev)
        return 0;
        else if(dp[i][j]!=-1)
        return dp[i][j];
        else
        {
            int x = Math.max(maxPath(matrix,dp,i+1,j,matrix[i][j]),
            maxPath(matrix,dp,i,j+1,matrix[i][j]));
            int y = Math.max(maxPath(matrix,dp,i-1,j,matrix[i][j]),
            maxPath(matrix,dp,i,j-1,matrix[i][j]));
            dp[i][j] = Math.max(x,y)+1;
            return dp[i][j];
        }


    }
    public int longestIncreasingPath(int[][] matrix) {
        int max =0;
        if(matrix.length==0) return 0;
        int [][] dp = new int [matrix.length][matrix[0].length] ;
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                int len = maxPath(matrix,dp,i,j,-1);
                if(len>max)
                max = len;
                
            }
        }
        return max;
    }
}
