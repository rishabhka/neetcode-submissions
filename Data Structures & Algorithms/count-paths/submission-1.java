class Solution {
    public int visit(int m,int n,int i,int j,boolean [][] visited)
    {
        if(i<0||j<0||i>=m||j>=n)
        return 0;
        else if (visited[i][j])
        return 0;
        else if(i==m-1&&j==n-1)
        return 1;
        else
        {
            System.out.println(i+ " "+ j);
            visited[i][j] = true; 
            int value = visit(m,n,i+1,j,visited) +
            visit(m,n,i,j+1,visited) ;
            visited[i][j] = false; 
            return value;

        }
    }
    public int uniquePaths(int m, int n) {
        boolean [] []  visited = new boolean [m][n];
        if(m==1||n==1)
        return 1;
        else
        {
        return  visit(m,n,0,0,visited);
  
        }
        
    }
}
