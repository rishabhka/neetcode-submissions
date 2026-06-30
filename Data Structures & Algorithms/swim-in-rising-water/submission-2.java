class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[2],b[2])
        );
        int [][] visited = new int[m][n] ;
        pq.add(new int[]{0,0,0});
        int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int max = grid[0][0] ;
        while(!pq.isEmpty())
        {
            int [] node = pq.poll();
            System.out.println(node[2]);
            visited[node[0]][node[1]] =1 ;
            if(max<grid[node[0]][node[1]])
            max = grid[node[0]][node[1]];
            for(int [] dir : dirs)
            {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                if(x==m-1&&y==n-1) return Math.max(max,grid[x][y]);
                if(x<0||y<0||x>=m||y>=n) continue ;
                if(visited[x][y]==1)
                continue ;
                pq.add(new int[]{x,y,grid[x][y]}) ;
            }
        }
        return max ;
        // (i,j) -> Add all 4 direcrtions in queue if not visited 
    }
}
