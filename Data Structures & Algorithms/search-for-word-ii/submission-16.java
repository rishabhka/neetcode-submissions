class Solution {
    class Trie 
    {
        Trie [] neigh ; boolean isEnd ; String word ;
        Trie() { neigh = new Trie [26] ; }
    }
    Trie root ;
    public void insert(String w)
    {
        Trie temp = root ;
        for(char ch : w.toCharArray())
        {
            if(temp.neigh[ch-'a']==null)
            {
                Trie node = new Trie();
                temp.neigh[ch-'a'] = node ;
            }
            temp = temp.neigh[ch-'a'] ;
        }
        temp.isEnd = true ;
        temp.word = w;
    }
    public void dfs(char[][] board,int i,int j,Trie temp,HashSet<String> res,boolean [][] visited)
    {
        int m = board.length ;
        int n = board[0].length ;
        Trie next = temp.neigh[board[i][j]-'a'] ;
        if(next == null) return ;

        if(next.isEnd==true) { res.add(next.word) ; }

            visited[i][j] = true ;
            int [][] dirs = new int [][] {{-1,0},{1,0},{0,-1},{0,1}} ;
            for(int [] dir : dirs )
            {
                int x = i + dir[0] ; int y = j + dir[1] ;
                if(x<0||y<0||x>=m||y>=n||visited[x][y]) continue ;
                dfs(board,x,y,next,res,visited);
            }
            visited[i][j] = false ;


    }
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> res = new HashSet<>();
        int m = board.length ;
        int n = board[0].length ;
        root = new Trie ();
        for(String word : words)
        insert(word) ;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                boolean [][] visited = new boolean [m][n] ;
                dfs(board,i,j,root,res,visited);
            }
        }
        return new ArrayList<>(res) ;
    }
}
