class Solution {
    public int f(int [][] board,int i,int j,int m,int n)
    {
        if(i>=m||j>=n||i<0||j<0)
        return Integer.MAX_VALUE;
        else
        {
        board[i][j] =  Math.min(board[i][j]+f(board,i+1,j,m,n),board[i][j]+f(board,i,j+1,m,n));
        return board[i][j];
        }
    }
    public int minPathSum(int[][] board) {
        // int board [][] = new int [m][n] ;
        int m = board.length;
        int n = board[0].length ;
        

        for(int i=1;i<m;i++)
        board[i][0] = board[i][0] + board[i-1][0] ;

        for(int i=1;i<n;i++)
        board[0][i] = board[0][i] + board[0][i-1] ;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++)
            {
                board[i][j] = Math.min(board[i][j]+board[i-1][j],board[i][j]+board[i][j-1]);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
        return board [m-1][n-1];
    }
}