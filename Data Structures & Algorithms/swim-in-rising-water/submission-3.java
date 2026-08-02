class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length ;
        int [][] dp = new int [n][n] ;
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],Integer.MAX_VALUE) ;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->
        {
            return Integer.compare(a[2],b[2]) ;
        }) ;
        pq.add(new int []{0,0,grid[0][0]}) ;
        dp[0][0] = grid[0][0] ;
        int [][] dirs = new int[][] {{0,-1},{0,1},{1,0},{-1,0}} ;
        while(!pq.isEmpty())
        {
            int [] node = pq.poll();
            if(node[0]==n-1&&node[1]==n-1) return node[2] ;
            for(int [] dir : dirs)
            {
                int x = node[0]+dir[0] ; int y = node[1]+dir[1] ;
                if(x<0||y<0||x>=n||y>=n) continue ;
                if(Math.max(node[2],grid[x][y])<dp[x][y])
                {
                   dp[x][y] = Math.max(node[2],grid[x][y]) ;
                   pq.offer(new int []{x,y,dp[x][y]}) ;
                }
            } 
        }
        return -1 ;
    }
}
