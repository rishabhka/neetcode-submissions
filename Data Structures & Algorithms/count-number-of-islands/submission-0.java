class Solution {
    
    public void traverse(char [][] grid, int i,int j,int n,int m)
    {
      if(i<0||j<0||i>=n||j>=m)
      return ;
      if(grid[i][j]=='1')
      {
        grid[i][j] = 'X' ;
       traverse(grid,i+1,j,n,m);
       traverse(grid,i,j+1,n,m);
       traverse(grid,i-1,j,n,m);
       traverse(grid,i,j-1,n,m);
    //    visited[i][j] == 1 ;
      }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        //Boolean [][] visited = new Boolean [n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
              if(grid[i][j]=='1')
              {
              traverse(grid,i,j,n,m);
              count ++;
              }
            }
        }
        return count ;
    }
}
