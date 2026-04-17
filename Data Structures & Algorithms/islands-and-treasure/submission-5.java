class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int [] > q = new LinkedList<>();
          int INF = 2147483647 ;
        

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    q.add(new int [] {i,j,0}); 
                }
            }
        }
                    
                        int [][] dirs = new int [][] {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty())
                    {
                        int [] idx = q.poll();

                        for(int [] dir :dirs)
                        {
                            int row = idx[0]+dir[0] ;
                            int col = idx[1]+dir[1];
                            int count = idx[2];
                            if(row<0||col<0||row>=m||col>=n)
                            continue ;
                            if(grid[row][col]==-1||grid[row][col] != INF)
                            continue ;
                            if(grid[row][col]>count+1)
                            grid[row][col] = count +1;
                            q.add(new int [] {row,col,count+1});
                        }
                        // count ++;

                    }
        return ;
    }
}
