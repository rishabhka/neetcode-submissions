class Solution {
    public static int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length ;

        Queue<int []> q = new LinkedList<>();

        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        if(grid[i][j]==0) q.add(new int []{i,j,0});
        int [][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
        while(!q.isEmpty())
        {
            int [] node = q.poll();
            if(grid[node[0]][node[1]]>node[2])
            grid[node[0]][node[1]] = node[2] ;
            for(int [] dir :dirs)
            {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                if(x<0||y<0||x>=m||y>=n||grid[x][y]==-1||grid[x][y]!=INF)
                continue ;
                else
                q.add(new int[]{x,y,node[2]+1});
            }
        }
        return ;
    }
}
