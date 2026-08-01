class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ; int sum =0 ;
        for(int i=0;i<m;i++)
        {
        sum = grid[i][0] + sum ;
        grid[i][0] = sum ;
        }
        sum =0 ;
        for(int i=0;i<n;i++)
        {
        sum = grid[0][i] + sum ;
        grid[0][i] = sum ;
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[m-1][n-1] ;
    }
}