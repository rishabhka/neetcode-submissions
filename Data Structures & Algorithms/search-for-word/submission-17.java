class Solution {
	public boolean dfs(int i ,int j,char [][] board,boolean [][] visited,String word , int k)
		{
		if(board[i][j]!=word.charAt(k) || visited[i][j]==true ) return false; k++;
		if(k==word.length()) return true ;	
		visited [i][j]  = true ;
		int [][] dirs = new int [][] {{0,-1},{-1,0},{1,0},{0,1} } ;
		for( int [] dir : dirs )
		{
		int x = dir[0] + i;
		int y = dir[1] + j;
		if(x<0||y<0||x>=board.length||y>=board[0].length) continue ;
		if(dfs(x,y,board,visited,word,k)) return true ;
		}
		visited [i][j]  = false ;
		return false;
		}
    public boolean exist(char[][] board, String word) {
		
        for(int i=0;i<board.length;i++)
		{
		for(int j=0;j<board[0].length;j++)
		{
		boolean [][] visited = new boolean [board.length][board[0].length] ;
		if(dfs(i,j,board,visited,word,0) ) return true ;
		}
		}
		return false;
    }
	
}