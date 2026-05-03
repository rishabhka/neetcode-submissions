class Solution {
    public void backtrack(char [][] board,int r)
    {
        if(r==board.length)
        {
            count ++;
        return ;
        }
        else
        {
            for(int c=0;c<board[0].length;c++)
            {
                if(canPlace(r,c,board))
                {
                board[r][c] = 'Q';
                backtrack(board,r+1);
                board[r][c] = '.';
                }
            }
            return ;
        }
        
    }
    public boolean canPlace(int r,int c,char [][] board)
    {
        for(int i =r-1;i>=0;i--)
        {
            if(board[i][c]=='Q')
            return false ;
        }
        for(int i =r-1, j=c+1;i>=0&&j<board.length;i--,j++)
        {
            if(board[i][j]=='Q')
            return false ;
        }
        for(int i =r-1, j=c-1;i>=0&&j>=0;i--,j--)
        {
            if(board[i][j]=='Q')
            return false ;
        }

        return true ;

    }
    int count =0;
    public int totalNQueens(int n) {
        
        char [][] board = new char[n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j] = '.';

            }
        }
        backtrack(board,0);
        return count;
    }
}