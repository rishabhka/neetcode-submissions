class Solution {
    public boolean path(char[][] board,String word,int i,int j,int n , int m,int [][] visited,int k)
    { 
      if(k==word.length())
      return true ;
      if(i>=n||j>=m||i<0||j<0)
      return false;
      if(visited[i][j]==1)
      return false;
      
      if(board[i][j]==word.charAt(k))
      {
        visited[i][j]=1;
        // String sub = word.substring(1,word.length());
      boolean found = path(board,word,i-1,j,n,m,visited,k+1)||path(board,word,i,j-1,n,m,visited,k+1)
      ||path(board,word,i+1,j,n,m,visited,k+1)||path(board,word,i,j+1,n,m,visited,k+1);
      if(found)
      return true;
      visited[i][j]=0;
      }
      
      return false ;
    }
    public boolean exist(char[][] board, String word) {
        int n= board.length ;
        int m = board[0].length ;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int visited [][] = new int [n][m];
                if(board[i][j]==word.charAt(0))
                if(path(board,word,i,j,n,m,visited,0))
                return true;
            }
        }
        return false;
    }
}
