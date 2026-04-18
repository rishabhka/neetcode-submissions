class Solution {
    public void solve(char[][] board) {
        int m = board.length ;
        int n = board[0].length ;
        Queue<int[] > q = new LinkedList<>();

        for(int i=0;i<m;i++)
        if(board[i][0]=='O') 
        {
        q.add(new int []{i,0});
        board[i][0] = 'K';
        }

        for(int i=0;i<n;i++)
        if(board[0][i]=='O') 
        {
        q.add(new int []{0,i});
        board[0][i] = 'K';
        }

        for(int i=0;i<m;i++)
        if(board[i][n-1]=='O') 
        {
        q.add(new int []{i,n-1});
        board[i][n-1] = 'K';
        }

        for(int i=0;i<n;i++)
        if(board[m-1][i]=='O') 
        {
        q.add(new int []{m-1,i});
        board[m-1][i] = 'K';
        }

        while(!q.isEmpty())
        {
            int [] node = q.poll();
            int [][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
            
            for(int [] dir : dirs)
            {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                if(x<0||y<0||x>=m||y>=n||board[x][y]!='O')
                continue ;
                else
                {
                q.add(new int[]{x,y});
                board[x][y] = 'K';
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O')
                board[i][j]='X' ;
                if(board[i][j]=='K')
                board[i][j]='O' ;
            }
        }
        return ;
    }
}
