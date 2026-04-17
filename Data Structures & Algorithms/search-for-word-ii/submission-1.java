class Solution {

    public boolean recur(char[][] board,String word,boolean [][] visited,int i,int j,int n,int m,int k)
    {
      if (k==word.length())
      return true ;
      if(i<0||i>=n||j<0||j>=m)
      return false ; 
      else if (visited[i][j]==true)
      return false;
      else if(board[i][j]==word.charAt(k))
      {
        visited[i][j]=true;
        Boolean flag = recur(board,word,visited,i+1,j,n,m,k+1) 
        || recur(board,word,visited,i,j+1,n,m,k+1) || recur(board,word,visited,i-1,j,n,m,k+1)
        || recur(board,word,visited,i,j-1,n,m,k+1) ;
        visited[i][j]=false;
        return flag ;
      }
      return false;


    }
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int k=0;k<words.length;k++)
        {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                boolean [][] visited = new boolean [n][m];
                if(recur(board,words[k],visited,i,j,n,m,0))
                set.add(words[k]);
            }
        }
        }
        for(String x : set)
        result.add(x);
        return result ;
    }
}
