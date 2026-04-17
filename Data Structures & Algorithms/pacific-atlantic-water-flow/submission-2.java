class Solution {
    public void dfs(int[][] heights,int i,int j,int m,int n,int [][] visited,HashSet<List<Integer>> atlantic)
    {
       visited[i][j] = 1 ;
       atlantic.add(Arrays.asList(i,j));
       int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}}; 
       for(int [] dir :dirs)
       {
        int x = i + dir[0];
        int y = j + dir[1] ;
        if(x<0||y<0||x>=m||y>=n)
        continue ;
        if(visited[x][y]!=1&&heights[i][j]<=heights[x][y])
        dfs(heights,x,y,m,n,visited,atlantic);
       }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;
        // List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> pacific = new HashSet<>();
        HashSet<List<Integer>> atlantic = new HashSet<>();
        int [][] visited1  = new int [m][n];
        int [][] visited2 = new int [m][n];
        for(int i=0;i<m;i++) // Go from pacific to every node
        {
            for(int j=0;j<n;j++)
            {
                if(i==0)
                {
                pacific.add(Arrays.asList(0,i))  ;  
                dfs(heights,i,j,m,n,visited1,pacific);
                }
                if(j==0)
                {
                pacific.add(Arrays.asList(i,0))  ;  
                dfs(heights,i,j,m,n,visited1,pacific);
                }

            }
        }
        for(int i=0;i<m;i++) // Go from atlantic to every node
        {
            for(int j=0;j<n;j++)
            {
                if(i==m-1)
                {
                atlantic.add(Arrays.asList(m-1,i))  ;  
                dfs(heights,i,j,m,n,visited2,atlantic);
                }
                if(j==n-1)
                {
                atlantic.add(Arrays.asList(i,n-1))  ;  
                dfs(heights,i,j,m,n,visited2,atlantic);
                }

            }
        }
        pacific.retainAll(atlantic);

        return new LinkedList<>(pacific) ;
        
    }
}
