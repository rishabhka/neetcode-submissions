class Solution {
    int max_count = 0 ;
    int count =0;
    public void f(int [][] grid,int i,int j,int m , int n)
    {
        if(i>=m||j>=n||i<0
        ||j<0)
        return ;
        if(grid[i][j]!=1)
        return ;
        else
        {
            count  ++ ;
            grid[i][j] = 2;
            f(grid,i+1,j,m,n);
            f(grid,i-1,j,m,n);
            f(grid,i,j+1,m,n);
            f(grid,i,j-1,m,n);
        }

    }
    public int maxAreaOfIsland(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                f(grid,i,j,m,n);
                if(max_count<count)
                max_count = count ;
                count = 0;
                }
                
            }
            
        }
        return max_count ;
    }
}
