class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Character>> row = new HashMap<>();
        HashMap<Integer,HashSet<Character>> col = new HashMap<>();
        HashMap<String,HashSet<Character>> box = new HashMap<>();

        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.') continue ;
                if(!row.containsKey(i))
                row.put(i,new HashSet<>());
                if(row.get(i).contains(board[i][j])) return false;
                row.get(i).add(board[i][j]) ;

                if(!col.containsKey(j))
                col.put(j,new HashSet<>());
                if(col.get(j).contains(board[i][j])) return false;
                col.get(j).add(board[i][j]) ;

                String s = (i/3)+","+(j/3);
                if(!box.containsKey(s))
                box.put(s,new HashSet<>());
                if(box.get(s).contains(board[i][j])) return false;
                box.get(s).add(board[i][j]) ;
            }
        }
        return true ;
    }
}
