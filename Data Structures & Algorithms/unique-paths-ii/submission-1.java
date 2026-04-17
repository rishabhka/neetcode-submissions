class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length ;
        int n = obstacleGrid[0].length ;
        int board [][] = new int [m][n] ;

        for(int i=0;i<m;i++)
        {
            if(obstacleGrid[i][0]==1||(i>0&&board[i-1][0]==0))
            board[i][0] = 0 ;
            else board[i][0] = 1 ;
        }
        

        for(int i=0;i<n;i++)
        {
            if(obstacleGrid[0][i]==1||(i>0&&board[0][i-1]==0))
            board[0][i] = 0 ;
            else board[0][i] = 1 ;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]==1)
                board[i][j] = 0;
                else 
                board[i][j]= board[i-1][j]+board[i][j-1] ;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
            {
                System.out.print(board [i][j]+" ");
            }
            System.out.println() ;
        }
        return board [m-1][n-1]==-1?0:board [m-1][n-1];
    }
}