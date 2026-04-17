class Solution {
    public void f(int i ,int j,int m,int n,int [][] visited)
    {
        if(i<0||j<0||i>m||j>n)
        return ;
        else
        {
            visited[i][j]= visited[i-1][j] + visited [i][j-1];
            f(1,1,m,n,visited) ;
            f(1,1,m,n,visited) ;
            System.out.println("je");
        }
    }
    public int uniquePaths(int m, int n) {
        if(m==1||n==1)
        return 1 ;
        int [][] visited = new int [m+1][n+1];
        for(int i=0;i<n;i++)
        visited[0][i]=1;
        for(int i=0;i<m;i++)
        visited[i][0]=1;
        // f(1,1,m,n,visited) ;
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                visited[i][j]= visited[i-1][j] + visited [i][j-1];
            }
        }
        return visited[m-1][n-1];
    }
}
