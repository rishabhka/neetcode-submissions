class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length ;
        int fresh_fruit = 0; 
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                fresh_fruit++;
                if(grid[i][j]==2)
                {
                q1.add(new int []{i,j});
                }
            }
        }
        if (fresh_fruit == 0) return 0; 
        int time = 0;
        int counter =0;
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q1.isEmpty()||!q2.isEmpty())
        {
            boolean flag = false;
            while(!q1.isEmpty())
            {
            int [] current_cell = q1.poll();
            for(int [] dir :dirs)
            {
            int i = current_cell[0] + dir[0] ;
            int j = current_cell[1] + dir[1] ;
            if(i<0||j<0||i>=m||j>=n)
            continue;
            if(grid[i][j]==1)
            {
                counter++;
                grid[i][j]=2 ;
                q2.add(new int []{i,j});
                 flag = true ;

            }
            }
            }
            if(flag)
            {
            time ++;
            flag = false;
            }
            while(!q2.isEmpty())
            {
            int [] current_cell = q2.poll();
            for(int [] dir :dirs)
            {
            int i = current_cell[0] + dir[0] ;
            int j = current_cell[1] + dir[1] ;
            if(i<0||j<0||i>=m||j>=n)
            continue;
            if(grid[i][j]==1)
            {
                counter++;
                grid[i][j]=2 ;
                q1.add(new int []{i,j});
                flag = true;
            }
            }
            }
            if(flag)
            time ++ ;
        }
        if(counter==fresh_fruit)
        return time;
        else
        return -1;
        
    }
}
