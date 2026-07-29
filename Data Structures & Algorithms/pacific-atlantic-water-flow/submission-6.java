class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length ; int n = heights[0].length ;
        Queue<int[]> atlantic = new LinkedList<>() ;
        Queue<int[]> pacific = new LinkedList<>() ;
        int [][] visited_p = new int[m][n] ;
        int [][] visited_a = new int[m][n] ;
        for(int i=0;i<n;i++)
        {
            pacific.add(new int [] {0,i}) ;
            visited_p[0][i] =2;
            atlantic.add(new int [] {m-1,i}) ;
            visited_a[m-1][i] =2;
        }
        for(int i=0;i<m;i++)
        {
            pacific.add(new int [] {i,0}) ;
            visited_p[i][0] =2;
            atlantic.add(new int [] {i,n-1}) ;
            visited_a[i][n-1] =2;
        }
        int [][] dirs = new int [][]{{-1,0},{1,0},{0,-1},{0,1}} ;
        while(!pacific.isEmpty())
        {
            int [] node = pacific.poll();
            for(int [] dir : dirs)
            {
                int x = node[0]+dir[0] ; int y = node[1]+dir[1] ;
                if(x<0||y<0||x>=m||y>=n||visited_p[x][y]!=0) continue ;
                if(heights[node[0]][node[1]]<=heights[x][y])
                {
                visited_p[x][y] = 2 ;    
                pacific.offer(new int[]{x,y}) ;
                }   
            }
        }
        while(!atlantic.isEmpty())
        {
            int [] node = atlantic.poll();
            for(int [] dir : dirs)
            {
                int x = node[0]+dir[0] ; int y = node[1]+dir[1] ;
                if(x<0||y<0||x>=m||y>=n||visited_a[x][y]!=0) continue ;
                if(heights[node[0]][node[1]]<=heights[x][y])
                {
                visited_a[x][y] = 2 ;    
                atlantic.offer(new int[]{x,y}) ;
                } 
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited_a[i][j]==2&&visited_p[i][j]==2)
                res.add(Arrays.asList(i,j));
            }
        }
        return res ;
    }
}
