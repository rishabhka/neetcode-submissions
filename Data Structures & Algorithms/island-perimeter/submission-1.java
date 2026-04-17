class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter =0;
        int n = grid[0].length;
        int m = grid.length ;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count =0 ;
                if(grid[i][j]==1)
                {
                    if(i>0&&grid[i-1][j]==1)
                    count ++ ;
                    if(j>0&&grid[i][j-1]==1)
                    count ++ ;
                    if(i<m-1&&grid[i+1][j]==1)
                    count ++ ;
                    if(j<n-1&&grid[i][j+1]==1)
                    count ++ ;
                if(count ==3) perimeter = perimeter +1 ;
                if(count ==2) perimeter = perimeter +2 ;
                if(count ==1) perimeter = perimeter +3 ;
                if(count ==0) perimeter = perimeter +4 ;
                }
                
            }
        }
        return perimeter ;
    }
}