class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh =0 ;
        int count =0;
        int max =0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int [] > q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                fresh ++ ;
                if(grid[i][j]==2)
                q.add(new int []{i,j,0});
            }
        }
        int [][] dirs = new int [][] {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty())
        {
            int [] node = q.poll();
            for(int [] dir : dirs)
            {
                int i = node[0]+dir[0];
                int j = node[1]+dir[1];
                int time = node[2];
                if(i<0||j<0||i>=m||j>=n)
                continue ;
                if(grid[i][j]==1)
                {
                    grid[i][j] = 2;
                    if(time+1>max)
                    max = time+1;
                    q.add(new int[] {i,j,time+1});
                    count ++ ;
                }
            }
        }

        return count==fresh ? max : -1;
    }
}
