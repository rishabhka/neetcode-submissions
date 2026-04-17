class Solution {
    public void infect (char[][] board,int i,int j,int [][] visited)
    {
        int m = board.length;
        int n = board[0].length;
        int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int [] dir : dirs)
        {
            int x = i + dir[0];
            int y = j+ dir[1];
            if(x<0||y<0||x>=m||y>=n)
            continue ;
            if(board[x][y]!='O')
            continue ;
            else 
            {
                board[x][y]='K' ;
                infect (board,x,y,visited) ;
            }
        }

    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int [][] visited = new int [m][n];
        for(int i=0;i<m;i++)
        {
            if(board[i][0]=='O')
            {
            board[i][0]='K' ;
            infect(board,i,0,visited);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O')
            {
            board[0][i]='K' ;    
            infect(board,0,i,visited);
            }
        }
        for(int i=0;i<n;i++)
        {
        if(board[m-1][i]=='O')
        {
        board[m-1][i]='K' ;    
        infect(board,m-1,i,visited);
        }
        }
        for(int i=0;i<m;i++)
        {
        if(board[i][n-1]=='O')
        {
        board[i][n-1]='K' ;
        infect(board,i,n-1,visited);
        }
        }
        for(int i=0;i<m;i++)
        {
        for(int j=0;j<n;j++)
        {
          if(board[i][j]=='O')
          board[i][j]='X';
          if(board[i][j]=='K')
          board[i][j]='O';
        }
        }
return ;
    }
}
