class Solution {
    public void solve(char[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            if(grid[i][n-1]=='O')  q.offer(new int []{i,n-1});
            if(grid[i][0]=='O') q.offer(new int []{i,0});
        }
        for(int i=0;i<n;i++)
        {
            if(grid[0][i]=='O') q.offer(new int []{0,i});
            if(grid[m-1][i]=='O') q.offer(new int []{m-1,i});
        }
        while(!q.isEmpty())
        {
            int [] node = q.poll();
            int [][] dirs = new int [][]{{-1,0},{1,0},{0,-1},{0,1}} ;
            grid[node[0]][node[1]] = 'P' ;
            for(int [] dir : dirs)
            {
                int x = node[0]+dir[0] ; int y = node[1]+dir[1] ;
                if(x<0||y<0||x>=m||y>=n||grid[x][y]!='O') continue ;
                // grid[x][y] = 'P' ;
                q.add(new int[]{x,y}) ;
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='O') grid[i][j]='X' ;
                if(grid[i][j]=='P') grid[i][j]='O' ;
            }
        }
        return ;

    }
}
