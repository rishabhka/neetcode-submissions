class Solution {
    public boolean path(char[][] board,String word,int i,int j,int n , int m,int [][] visited)
    { 
      if(word.equals(""))
      return true ;
      if(i>=n||j>=m||i<0||j<0)
      return false;
      if(visited[i][j]==1)
      return false;
      
      if(board[i][j]==word.charAt(0))
      {
        visited[i][j]=1;
        for(int p=0;p<n;p++)
      {
        for(int q=0;q<m;q++)
        System.out.print(visited[p][q]);
        System.out.println();
      } 
        String sub = word.substring(1,word.length());
        System.out.println(word.charAt(0)+" "+word);
      boolean found = path(board,sub,i-1,j,n,m,visited)||path(board,sub,i,j-1,n,m,visited)
      ||path(board,sub,i+1,j,n,m,visited)||path(board,sub,i,j+1,n,m,visited);
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
                if(path(board,word,i,j,n,m,visited))
                return true;
            }
        }
        return false;
    }
}
