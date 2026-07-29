class Solution {
    public void  dfs(int [][] grid,int i,int j,int [] res)
    {
        int m = grid.length ;
        int n = grid[0].length ;
        int [][] dirs = new int [][] {{-1,0},{1,0},{0,1},{0,-1}} ;
        res[0] ++ ;
        for(int []dir : dirs )
        {
            int x = i + dir[0] ; int y = j + dir[1] ;
            if(x<0||y<0||x>=m||y>=n||grid[x][y]!=1) continue ;
            grid[x][y] = 2;
            dfs(grid,x,y,res);
        }

    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ; int max = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int [] res = new int [1] ;
                if(grid[i][j]==1) 
                {
                grid[i][j] = 2;    
                dfs(grid,i,j,res);
                }
                max = Math.max(res[0],max);
            }
        }
        return max ;
    }
}
