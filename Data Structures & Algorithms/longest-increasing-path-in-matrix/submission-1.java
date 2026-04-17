class Solution {
    int len = 0 ;
    public void track(int [][] matrix,int i,int j,int m,int n,int curr_len,int [][] visited)
    {
        System.out.println(i+" "+j);
        if(i>=m||j>=n||i<0||j<0)
        return ;
        if(visited[i][j]==1)
        return ;
        else
        {
        visited[i][j]=1 ;
        if(curr_len>len)
        len = curr_len ;
        if(i<m-1&&matrix[i][j]<matrix[i+1][j])
        track(matrix,i+1,j,m,n,curr_len+1,visited);
        if(i>0&&matrix[i][j]<matrix[i-1][j])
        track(matrix,i-1,j,m,n,curr_len+1,visited);
        if(j<n-1&&matrix[i][j]<matrix[i][j+1])
        track(matrix,i,j+1,m,n,curr_len+1,visited);
        if(j>0&&matrix[i][j]<matrix[i][j-1])
        track(matrix,i,j-1,m,n,curr_len+1,visited);
        }
        visited[i][j]=2;
        return ;

    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length ;
        int n = matrix[0].length ;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int [][] visited = new int [m][n];
                track(matrix,i,j,m,n,1,visited);
            }
        }
        return len ;
    }
}
