class Solution {

    public void traverse(int [][] heights,int i,int j,int n,int m,boolean [][] visited,boolean[] flag)
    {
        if(flag[0]&&flag[1])
        return ;

        if(!visited[i][j])
        {
        visited[i][j] = true;
        
        if(i==0)
        flag[0]= true;
        else if(heights[i][j]>=heights[i-1][j])
        traverse(heights,i-1,j,n,m,visited,flag) ;

        if(j==0)
        flag[0]= true;
        else if(heights[i][j]>=heights[i][j-1])
        traverse(heights,i,j-1,n,m,visited,flag);

        if(i==n-1)
        flag[1]= true;
        else if(heights[i][j]>=heights[i+1][j])
        traverse(heights,i+1,j,n,m,visited,flag) ;

       if(j==m-1)
       flag[1]= true;
       else if(heights[i][j]>=heights[i][j+1])
        traverse(heights,i,j+1,n,m,visited,flag) ;

        visited[i][j] = false;
        }
        return;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int n  = heights.length;
        int m = heights[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                boolean []  flag = new boolean [2];
                boolean visited [][] = new boolean[n][m] ;
                traverse(heights,i,j,n,m,visited,flag);
                if(flag[0]&&flag[1])
                result.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return result;
    }
}