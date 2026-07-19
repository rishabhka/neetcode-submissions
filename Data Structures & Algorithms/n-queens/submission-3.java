class Solution {
    public boolean check(int r, int c, char[][] board) {
        for (int i = r - 1; i >= 0; i--)                          // column above
            if (board[i][c] == 'Q') return false;
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) // upper-left diagonal
            if (board[i][j] == 'Q') return false;
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) // upper-right diagonal
            if (board[i][j] == 'Q') return false;
        return true;
    }

    public void dfs(int r, char[][] board, List<List<String>> res) {
        int n = board.length;
        if (r == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++)
                temp.add(new String(board[i]));
            res.add(temp);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (check(r, c, board)) {
                board[r][c] = 'Q';
                dfs(r + 1, board, res);
                board[r][c] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');
        dfs(0, board, res);
        return res;
    }
}