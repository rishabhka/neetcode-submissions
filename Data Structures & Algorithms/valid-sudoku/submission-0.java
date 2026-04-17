class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character > set = new HashSet<>();
        int n = board.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!set.contains(board[i][j]))
                {
                    if(board[i][j]!='.')
                    set.add(board[i][j]);
                }
                else return false;
            }
            set.clear();
        }
        set.clear();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!set.contains(board[j][i]))
                {
                    if(board[j][i]!='.')
                    set.add(board[j][i]);
                }
                else return false;
            }
            set.clear();
        }
        set.clear();
        for(int i=0;i<n;i=i+3)
        {
            for(int j=0;j<n;j=j+3)
            {
                for(int p = i;p<i+3;p++)
                {
                    for(int q=j;q<j+3;q++)
                    {
                        System.out.println(p+ " "+q);

                    if(!set.contains(board[p][q]))
                   {
                    if(board[p][q]!='.')
                    set.add(board[p][q]);
                   }
                   else return false;
                    }
                }
                set.clear();
                
            }
            set.clear();
        }
        return true;
    }
}
