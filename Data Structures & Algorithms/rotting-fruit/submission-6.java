class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        int time =0; int ff =0;
        int count =0;
        Queue<int[] > q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1) ff++;
                if(grid[i][j]==2) 
                q.add(new int[]{i,j,0});
            }
        }
        while(!q.isEmpty())
        {
            int [] node = q.poll();
            time = Math.max(time,node[2]);
            int [][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
            // if(grid[node[0]][node[1]] == 1) count++;
            // grid[node[0]][node[1]] = 2;
            for(int [] dir : dirs)
            {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                if(x<0||y<0||x>=m||y>=n||grid[x][y]!=1)
                continue ;
                else
                {
                q.add(new int[]{x,y,node[2]+1});
                grid[x][y] = 2;
                count++;
                }
            }
        }
        System.out.println(count);
        return ff==count?time:-1;
    }
}
