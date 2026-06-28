class Solution {
    public int visit(int [][] grid,int i,int j)
    {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length)
        return 0 ;
        if(grid[i][j]!=1)
        return 0;
        grid[i][j]=2;
        return visit(grid,i+1,j) + visit(grid,i,j+1)+visit(grid,i-1,j)+
        visit(grid,i,j-1) + 1;

    }
    public int maxAreaOfIsland(int[][] grid) {
        int max =0 ;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int area = visit(grid,i,j);
                    if(max<area)
                    max=area ;
                }
                
            }
        }
        return max;
    }
}
