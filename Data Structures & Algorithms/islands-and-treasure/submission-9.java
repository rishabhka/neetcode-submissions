class Solution {
    static int INF = 2147483647; 
    public void islandsAndTreasure(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                q.add(new int[]{i,j,0});
            }
        }
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty())
        {
            int [] node = q.poll();
            for(int [] dir : dirs)
            {
                int x = node[0] + dir[0] ;
                int y = node[1] + dir[1] ;
                if(x<0||y<0||x>=grid.length||y>=grid[0].length)
                continue ;
                if(grid[x][y]==INF)
                {
                    grid[x][y]= node[2] + 1;
                    q.add(new int []{x,y,node[2]+1});
                }

            }
        }
        return ;
    }
}
