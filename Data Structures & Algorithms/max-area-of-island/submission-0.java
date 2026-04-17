class Solution {
    int count = 2;
    public void visit(int[][] grid,int i , int j,int m , int n)
    {
        if(i<0||j<0||i>m-1||j>n-1)
        return ;
        else if(grid[i][j]==1)
        {
          grid[i][j] = count ;
          visit(grid,i+1,j,m,n);
          visit(grid,i,j+1,m,n);
          visit(grid,i,j-1,m,n);
          visit(grid,i-1,j,m,n);
        }

    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    visit(grid,i,j,m,n);
                    count ++ ;
                }
            }
        }
        int c [] = new int[count+2];
        int result = Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(grid[i][j]);
                c[grid[i][j]]++;

            }
            System.out.println();
        }
        for(int i=2;i<c.length;i++)
        {
            if(result<c[i])
            result = c[i];
        }
        return result;
        
        }
}
