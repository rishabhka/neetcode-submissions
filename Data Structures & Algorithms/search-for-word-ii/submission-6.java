class Solution {
	Trie root ;
	List<String> result ;
	public class Trie
	{
		Trie [] mapping ;
		boolean isEnd  ;
		String word ;
		Trie()
		{
		mapping = new Trie [26];
		isEnd = false ;
		word = "";
		}
	}
	public void f(char[][] board, int [][] visited,int i , int j ,int row , int col , int k,Trie temp)
	{
		// if(k>=word.length())
		// return  ;
		if(i>=row||j>=col||i<0||j<0||visited[i][j]==1)
		return  ;
		else if (temp.mapping[board[i][j]-'a']==null)
		return ;
		else
		{
				
				visited [i][j] = 1 ;
				temp = temp.mapping[board[i][j]-'a'] ;
				if(temp.isEnd == true)
				{
				result.add(temp.word);
				temp.isEnd = false;
		}
				f(board,visited,i-1,j,row,col,k+1,temp) ; 
				f(board,visited,i+1,j,row,col,k+1,temp) ;
				f(board,visited,i,j+1,row,col,k+1,temp) ;
				f(board,visited,i,j-1,row,col,k+1,temp) ;
				visited[i][j] = 0; 

		}

	}
	public void add(String word)
	{
		Trie temp = root ;
		for(int i=0;i<word.length();i++)
		{
			int curr = word.charAt(i)-'a' ;
			if(temp.mapping[curr]==null)
			{
				Trie newNode = new Trie();
				temp.mapping[curr] = newNode ;
			}
		temp = temp.mapping[curr];
		}
		temp.isEnd = true ;
		temp.word = word ;

	}
    public List<String> findWords(char[][] board, String[] words) {
		int row = board.length ;
		int col = board[0].length ;
        int [][] visited  ;
		result = new ArrayList<>();
		root = new Trie ();
		for(String word : words)
		{
			add(word);
		}
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				visited = new int [row][col] ;
				f(board,visited,i,j,row,col,0,root) ;
			}
		}
		

		return result ;
    }
}
