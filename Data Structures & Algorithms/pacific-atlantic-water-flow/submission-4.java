class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length ; 
        int n = heights[0].length ; 
        List<List<Integer>> result = new ArrayList<>();
        int[][] pacific_visited = new int [m][n];
        int[][] atlantic_visited = new int [m][n];
        Queue<int[] > pacific = new LinkedList<>();
        Queue<int[] > atlantic = new LinkedList<>();

        for(int i=0;i<m;i++)
        {
           pacific.add(new int[]{i,0});
           atlantic.add(new int[]{i,n-1});
           pacific_visited[i][0] =  1;
           atlantic_visited[i][n-1] = 1;
        }
        for(int i=0;i<n;i++)
        {
           pacific.add(new int[]{0,i});
           atlantic.add(new int[]{m-1,i});
           pacific_visited[0][i] =  1;
           atlantic_visited[m-1][i] = 1;
        }
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!pacific.isEmpty())
        {
            int [] node = pacific.poll();
            for(int [] dir : dirs)
            {
                int x = node[0] + dir[0] ;
                int y = node[1] + dir[1] ;
                if(x<0||y<0||x>=m||y>=n||pacific_visited[x][y]==1)
                continue ;
                if(heights[x][y]>= heights[node[0]][node[1]])
                {
                    pacific.add(new int[]{x,y});
                    pacific_visited[x][y]=1;

                }
            }
        }
        while(!atlantic.isEmpty())
        {
            int [] node = atlantic.poll();
            for(int [] dir : dirs)
            {
                int x = node[0] + dir[0] ;
                int y = node[1] + dir[1] ;
                if(x<0||y<0||x>=m||y>=n||atlantic_visited[x][y]==1)
                continue ;
                if(heights[x][y]>= heights[node[0]][node[1]])
                {
                    atlantic.add(new int[]{x,y});
                    atlantic_visited[x][y]=1;

                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(atlantic_visited[i][j]+pacific_visited[i][j]==2)
                result.add(Arrays.asList(i, j));
            }
        }
        return result ;
    }
}
