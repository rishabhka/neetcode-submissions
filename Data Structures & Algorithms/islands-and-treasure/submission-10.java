class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = 2147483647 ;
        Queue<int []> q = new LinkedList<>();
        int m = grid.length ;
        int n = grid[0].length ;
        int [][] visited = new int [m][n] ;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                q.add(new int []{i,j,0}) ;
                visited[i][j] = 1;
                }
            }
        }
        while(!q.isEmpty())
        {
            int [] node = q.poll();
            int [][] dirs = new int [][]{{-1,0},{1,0},{0,-1},{0,1}} ;
            
            for(int [] dir : dirs)
            {
                int x = node[0]+dir[0] ; int y = node[1]+dir[1] ;
                if(x<0||y<0||x>=m||y>=n||grid[x][y]!=INF||visited[x][y]==1) continue ;
                visited[x][y] = 1;
                grid[x][y] = node[2] + 1;
                q.add(new int[]{x,y,node[2]+1}) ;
            }
        }
        return ;
    }
}
