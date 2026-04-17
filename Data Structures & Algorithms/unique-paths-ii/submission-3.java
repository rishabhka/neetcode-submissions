class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length ;
        int n = obstacleGrid[0].length ;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(obstacleGrid[i][j]==1)
                obstacleGrid[i][j]=-1;
            }
        }
        boolean prev = false ;
        for(int i=0;i<m;i++)
        {
            if(prev||obstacleGrid[i][0]==-1)
            {
                prev = true ;
                obstacleGrid[i][0] = -1 ;
            }
            else 
            obstacleGrid[i][0] = 1 ;
        }
        prev = false;
        for(int j=0;j<n;j++)
        {
            if(prev||obstacleGrid[0][j]==-1)
            {
                prev = true ;
                obstacleGrid[0][j] = -1 ;
            }
            else obstacleGrid[0][j] = 1 ;
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(obstacleGrid[i][j]) ;
            }
            System.out.println(" ");
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]==-1)
                continue ;
                if(obstacleGrid[i-1][j]==-1)
                obstacleGrid[i][j]= obstacleGrid[i][j-1] ;
                else if (obstacleGrid[i][j-1]==-1)
                obstacleGrid[i][j]= obstacleGrid[i-1][j] ;
                else
                obstacleGrid[i][j]= obstacleGrid[i-1][j] + obstacleGrid[i][j-1] ;
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(obstacleGrid[i][j]) ;
            }
            System.out.println(" ");
        }
        return obstacleGrid[m-1][n-1]==-1?0:obstacleGrid[m-1][n-1] ;
    }
}