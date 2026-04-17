class Solution {
    int count = 2;
    public void visit(int[][] grid,int i , int j,int m , int n , int [] c)
    {
        if(i<0||j<0||i>m-1||j>n-1)
        return ;
        else if(grid[i][j]==1)
        {
          c[0]=c[0]+1;
          grid[i][j] = count ;
          visit(grid,i+1,j,m,n,c);
          visit(grid,i,j+1,m,n,c);
          visit(grid,i,j-1,m,n,c);
          visit(grid,i-1,j,m,n,c);
        }

    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        int result = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    int [] c = new int[1] ;
                    visit(grid,i,j,m,n,c);
                    if(result<c[0])
                    result = c[0];
                    count ++ ;
                }
            }
        }
        return result;
        
        }
}
