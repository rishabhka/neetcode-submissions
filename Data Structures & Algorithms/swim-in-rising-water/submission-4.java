class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
        {
            return Integer.compare(a[2], b[2]);
        });
        int m = grid.length; int n = grid[0].length;
        pq.offer(new int[]{0, 0, grid[0][0]});          // ← start cost = the start cell's value (not 0)
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] visited = new int[m][n];
        visited[0][0] = 1;
        while (!pq.isEmpty())
        {
            int[] node = pq.poll();
            if (node[0] == m - 1 && node[1] == n - 1) return node[2];
            visited[node[0]][node[1]] = 1;
            for (int[] dir : dirs)
            {
                int x = node[0] + dir[0]; int y = node[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] == 1) continue;
                pq.offer(new int[]{x, y, Math.max(node[2], grid[x][y])});   // ← max with the NEIGHBOR's cell value
            }
        }
        return -1;
    }
}