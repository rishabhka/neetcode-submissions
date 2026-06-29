class Solution {
    class TrieNode
    {
        TrieNode [] mapping = new TrieNode[26];
        boolean isWord = false;
    }
    TrieNode root = new TrieNode();
    public void add(String word)
    {
        TrieNode temp = root;
        for(char ch : word.toCharArray())
        {
            if(temp.mapping[ch-'a']==null)
            {
                TrieNode node = new TrieNode();
                temp.mapping[ch-'a'] = node;
            }
            temp = temp.mapping[ch-'a'] ;
        }
        temp.isWord=true;

    }

    public void dfs(char[][] board,int i,int j,HashSet<String> result,int [][] visited,String curr,TrieNode temp)
    {
        if(i<0||j<0||i>=board.length||j>=board[0].length||visited[i][j]==1)
        return ;
        else if (temp.mapping[board[i][j]-'a']==null) return ;

        visited[i][j] = 1;
        TrieNode next =temp.mapping[board[i][j]-'a'];
        if(next.isWord==true)
        {
            result.add(new String(curr+board[i][j]));
        }
        dfs(board,i+1,j,result,visited,curr+board[i][j],next);
        dfs(board,i,j+1,result,visited,curr+board[i][j],next);
        dfs(board,i-1,j,result,visited,curr+board[i][j],next);
        dfs(board,i,j-1,result,visited,curr+board[i][j],next);
        visited[i][j] = 0;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode temp = root;
        for(String word:words)
        add(word);
        HashSet<String> result = new HashSet<>();
        int [][] visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                dfs(board,i,j,result,visited,"",temp);
            }
        }
        return new ArrayList<>(result);
    }
}
