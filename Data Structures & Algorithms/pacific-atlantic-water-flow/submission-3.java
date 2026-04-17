class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean [][] visitedAtl = new boolean [m][n];
        boolean [][] visitedPac = new boolean [m][n];
        // for(int i=0;i<m;i++)
        // {
        // Arrays.fill(visitedAtl[i],-1);
        // Arrays.fill(visitedPac[i],-1);
        // }
        // int [][] sum = new int [m][n];
        Queue<int []> pac = new LinkedList<>();
        Queue<int []> atl = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            atl.add(new int []{m-1,i});
            pac.add(new int []{0,i});
            // sum[m-1][i] = sum[m-1][i] +1 ;
            // sum[0][i] = sum[0][i] +1 ;
            visitedAtl[m-1][i]=true;
            visitedPac[0][i]=true;
        }
        for(int i=0;i<m;i++)
        {
            pac.add(new int []{i,0});
            atl.add(new int []{i,n-1});
            // sum[i][0] = sum[i][0] +1 ;
            // sum[i][n-1] = sum[i][n-1] +1 ;
            visitedPac[i][0]=true;
            visitedAtl[i][n-1]=true;
        }
        int [][] dirs = new int [][] {{-1,0},{1,0},{0,-1},{0,1}};
        while(!pac.isEmpty())
        {
            int [] node = pac.poll();
             for(int [] dir : dirs)
            {
                int i = node[0]+dir[0];
                int j = node[1]+dir[1];
                if(i<0||j<0||i>=m||j>=n)
                continue ;
                if(visitedPac[i][j]==false)
                {
                    if(heights[node[0]][node[1]]<=heights[i][j])
                    {
                    pac.add(new int []{i,j});
                    // sum[i][j] = sum[i][j] +1;
                    visitedPac[i][j]=true;
                    }
                    
                }
            }

        }
        while(!atl.isEmpty())
        {
            int [] node = atl.poll();
             for(int [] dir : dirs)
            {
                int i = node[0]+dir[0];
                int j = node[1]+dir[1];
                if(i<0||j<0||i>=m||j>=n)
                continue ;
                if(visitedAtl[i][j]==false)
                {
                    if(heights[node[0]][node[1]]<=heights[i][j])
                    {
                    atl.add(new int []{i,j});
                    // sum[i][j] = sum[i][j] +1;
                    visitedAtl[i][j]=true;
                    }
                    
                }
            }

        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
        {
            if(visitedAtl[i][j]&&visitedPac[i][j])
            result.add(Arrays.asList(i,j));
        }
        }
        return result ;
    }
}
