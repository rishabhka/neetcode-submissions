class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            if(board[i][n-1]=='O')
            {
            q.add(new int [] {i,n-1} ) ;
            board[i][n-1] = '2';
            }
            if(board[i][0]=='O')
            {
            q.add(new int [] {i,0} ) ;
            board[i][0] = '2';
            }
        }
        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O')
            {
            q.add(new int [] {0,i} ) ;
            board[0][i] = '2';
            }
            if(board[m-1][i]=='O')
            {
            q.add(new int [] {m-1,i} ) ;
            board[m-1][i] = '2';
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
                if(i<0||j<0||i>=m||j>=n)
                continue ;
                if(board[i][j]=='O')
                {
                board[i][j] = '2';
                q.add(new int []{i,j});
                }
                }
            }
            for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
        {
            if(board[i][j]=='O')
            board[i][j]='X';
            if(board[i][j]=='2')
            board[i][j]='O';

        }
        }
return ;
        }
    }
