class Solution {
    public void backtrack(char [][] board,int r,List<List<String>> result)
    {
        if(r==board.length)
        {
            int n = board.length ;
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
            String str = "";
            for(int j=0;j<n;j++)
            {
                str = str + board[i][j];

            }
            temp.add(str);
            }
            result.add(temp);
        return ;
        }
        else
        {
            for(int c=0;c<board[0].length;c++)
            {
                if(canPlace(r,c,board))
                {
                board[r][c] = 'Q';
                backtrack(board,r+1,result);
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
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char [][] board = new char[n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j] = '.';

            }
        }
        backtrack(board,0,result);
        return result;
    }
}
