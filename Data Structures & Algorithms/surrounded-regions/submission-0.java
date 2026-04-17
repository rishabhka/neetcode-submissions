class Solution {
    public void visit(char[][] board,int i,int j,int m,int n)
    {
        if(i<0||j<0||i>=m||j>=n)
        return ;
        if(board[i][j]!='O')
        return ;
        else
        {
           board[i][j] = 'K';
           visit(board,i-1,j,m,n);
           visit(board,i+1,j,m,n);
           visit(board,i,j+1,m,n);
           visit(board,i,j-1,m,n);
        }

    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length ;
        Queue<int[]> q = new LinkedList<>();
        int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int count = 1 ;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i==0||j==0||i==m-1||j==n-1)&&board[i][j]=='O')
                visit(board,i,j,m,n);
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
