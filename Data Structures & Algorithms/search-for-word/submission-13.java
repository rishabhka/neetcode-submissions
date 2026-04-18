class Solution {
    public boolean dfs(char [][] board,String word,int i,int j , int k,int [][] visited)
    {
        int m = board.length;
        int n = board[0].length ;
        if(k==word.length())
        return true ;
        else if(i<0||j<0||i>=m||j>=n)
        return false ;
        else if(visited[i][j]==1)
        return false ;
        else
        {
            boolean flag = false;
            visited [i][j] = 1 ;
            if(board[i][j]==word.charAt(k))
            flag = dfs(board,word,i+1,j,k+1,visited) || dfs(board,word,i-1,j,k+1,visited)
            || dfs(board,word,i,j+1,k+1,visited) || dfs(board,word,i,j-1,k+1,visited) ;
            visited [i][j] = 0 ;
            return flag ;
        }
        


    }
    public boolean exist(char[][] board, String word) {
        if(word.length()==0)
        return true ;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    int [][] visited = new int [board.length][board[0].length];
                    if(dfs(board,word,i,j,0,visited))
                    return true ;
                }
            }
        }
        return false ;
    }
}
