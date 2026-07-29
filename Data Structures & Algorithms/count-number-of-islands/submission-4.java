class Solution {
    public void visit(char [][] grid,int x,int y)
    {
        grid[x][y]='2';
        int [][] dirs = new int [][] {{0,-1},{1,0},{-1,0},{0,1}} ;
        for(int [] dir : dirs)
        {
        int i = dir[0] + x ;    int j = dir[1] + y ;    
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!='1') continue ;
        visit(grid,i,j);
        }

    }
    public int numIslands(char[][] grid) {
        int count =0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                visit(grid,i,j);
                count++;
                }
            }
        }
        return count;
    }
}
