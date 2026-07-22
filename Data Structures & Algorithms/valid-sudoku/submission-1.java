class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++)
        {
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='.') continue ;
                if(set.contains(board[i][j]))
                return false;
                set.add(board[i][j]);
            }

        }
        for(int i=0;i<board[0].length;i++)
        {
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<board.length;j++)
            {
                if(board[j][i]=='.') continue ;
                if(set.contains(board[j][i]))
                return false;
                set.add(board[j][i]);
            }

        } 
        for(int p=0;p<3;p++)
        {
            for(int q=0;q<3;q++)
            {
                HashSet<Character> set = new HashSet<>();
                for(int i=3*p;i<3*(p+1);i++)
                {
                    for(int j=3*q;j<3*(q+1);j++)
                    {
                    if(board[i][j]=='.') continue ;    
                    if(set.contains(board[i][j]))
                    return false;
                    set.add(board[i][j]);
                    }
                }
            }    
        }
        return true ;
    }
}
