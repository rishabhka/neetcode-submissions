class Solution {
    public void f(char [][] grid,int i,int j,int m , int n)
    {
        if(i>=m||j>=n||i<0
        ||j<0)
        return ;
        if(grid[i][j]!='1')
        return ;
        else
        {
            grid[i][j] = '2';
            f(grid,i+1,j,m,n);
            f(grid,i-1,j,m,n);
            f(grid,i,j+1,m,n);
            f(grid,i,j-1,m,n);
        }

    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count =0 ;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                f(grid,i,j,m,n);
                count ++;
                }
            }
        }
        return count ;
    }
}
