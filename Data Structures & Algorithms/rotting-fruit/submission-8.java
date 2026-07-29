class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int m = grid.length ;
        int n = grid[0].length ; int fresh =0 ; int count = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1) count  ++ ;
                if(grid[i][j]==2)
                {
                    q.offer(new int []{i,j,0}) ;
                }
            }
        }
        int max_time = 0 ;
        while(!q.isEmpty())
        {
            int [] node = q.poll();
            int [][] dirs = new int [][]{{-1,0},{1,0},{0,-1},{0,1}} ;
            max_time = Math.max(max_time,node[2]) ;
            for(int [] dir : dirs)
            {
                int x = node[0]+dir[0] ; int y = node[1]+dir[1] ;
                if(x<0||y<0||x>=m||y>=n||grid[x][y]!=1) continue ;
                fresh ++ ;
                grid[x][y]=2 ;
                q.add(new int [] {x,y,node[2]+1}) ;
            }
        }
        return (fresh ==count)?max_time:-1 ;
    }
}
