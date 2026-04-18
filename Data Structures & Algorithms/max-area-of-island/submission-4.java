class Solution {
    int max_area =0;
    int temp =0 ;
    public void dfs(int [][] grid,int i,int j,int m , int n)
    {
        if(i<0||j<0||i>=m||j>=n)
        return ;
        else if(grid[i][j]!=1)
        return ;
        else
        {
            grid[i][j] = 2;
            temp++;
            dfs(grid,i+1,j,m,n);
            dfs(grid,i,j+1,m,n);
            dfs(grid,i-1,j,m,n);
            dfs(grid,i,j-1,m,n);
        }

    }
    public int maxAreaOfIsland(int[][] grid) {
       int m = grid.length;
        int n = grid[0].length ;
        int count =0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                temp =0;
                dfs(grid,i,j,m,n);
                if(temp>max_area)
                max_area = temp;
                }
            }
        }
        return max_area ; 
    }
}
