class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ; boolean flag = false ;
        if(grid[0][0]==1) return 0;
        for(int i=0;i<m;i++)
        {
        if(grid[i][0]==1||flag) { grid[i][0] = -1 ; flag = true ; }
        else grid[i][0] = 1 ;
        }
        flag = false ;
        for(int i=1;i<n;i++)
        {
        if(grid[0][i]==1||flag) { grid[0][i] = -1 ; flag = true ; }
        else grid[0][i] = 1 ;
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(grid[i][j]==1) 
                {
                grid[i][j] = -1 ; continue ;
                }
                int x = grid[i-1][j]==-1?0:grid[i-1][j] ;
                int y = grid[i][j-1]==-1?0:grid[i][j-1] ;
                grid[i][j]= x + y ;
            }
        }
        return grid[m-1][n-1]==-1?0:grid[m-1][n-1] ;
    }
}