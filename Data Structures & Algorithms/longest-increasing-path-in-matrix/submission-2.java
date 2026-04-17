class Solution {
    int len = 0 ;
    public int track(int [][] matrix,int i,int j,int m,int n,int [][] visited,int [][] dp)
    {
        if(i>=m||j>=n||i<0||j<0)
        return 0;
        else if(visited[i][j]==1)
        return 0;
        else if(dp[i][j]!=-1)
        return dp[i][j] ;
        else
        {
        int len1=0,len2=0,len3=0,len4=0 ; 
        visited[i][j]=1 ;
        if(i<m-1&&matrix[i][j]<matrix[i+1][j])
        len1 =track(matrix,i+1,j,m,n,visited,dp)+1;
        if(i>0&&matrix[i][j]<matrix[i-1][j])
        len2= track(matrix,i-1,j,m,n,visited,dp)+1;
        if(j<n-1&&matrix[i][j]<matrix[i][j+1])
        len3= track(matrix,i,j+1,m,n,visited,dp)+1;
        if(j>0&&matrix[i][j]<matrix[i][j-1])
        len4= track(matrix,i,j-1,m,n,visited,dp)+1;
        dp[i][j] = Math.max(len1,Math.max(len2,Math.max(len3,len4)));
        if(dp[i][j]>len)
        len = dp[i][j] ;
        visited[i][j]=2;
        return dp[i][j] ;
        }

    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length ;
        int n = matrix[0].length ;
        if(m==0)
        return 0;
        int [][] dp = new int [m][n] ;
        for(int i=0;i<m;i++)
        Arrays.fill(dp[i],-1);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int [][] visited = new int [m][n];
                track(matrix,i,j,m,n,visited,dp);
            }
        }
        return len + 1 ;
    }
}