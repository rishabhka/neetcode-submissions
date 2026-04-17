class Solution {
	public boolean f(char[][] board,String word, int [][] visited,int i , int j ,int row , int col , int k)
	{
		if(k==word.length())
		return true ;
		if(i>=row||j>=col||i<0||j<0||visited[i][j]==1)
		return false ;
		else
		{
			if(word.charAt(k)==board[i][j])
			{
				visited [i][j] = 1 ;
				return f(board,word,visited,i-1,j,row,col,k+1) || 
				f(board,word,visited,i+1,j,row,col,k+1) || 
				f(board,word,visited,i,j+1,row,col,k+1) ||
				f(board,word,visited,i,j-1,row,col,k+1) ;
				
			}
		return false ;

		}

	}
    public List<String> findWords(char[][] board, String[] words) {
		int row = board.length ;
		int col = board[0].length ;
        int [][] visited  ;
		List<String> result = new ArrayList<>();


		for(String word : words)
		{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				visited = new int [row][col] ;
				if(result.size()>0&&result.get(result.size()-1).equals(word))
				break ;
				if(f(board,word,visited,i,j,row,col,0))
				{
				result.add(word);
				break ;
				}
			}
		}
		}
		

		return result ;
    }
}
