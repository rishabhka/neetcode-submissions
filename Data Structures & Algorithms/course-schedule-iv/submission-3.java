class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {

        boolean[][] reachable = new boolean[n][n];

        for (int[] p : prerequisites)
            reachable[p[0]][p[1]] = true;

        // Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    reachable[i][j] =
                        reachable[i][j] || (reachable[i][k] && reachable[k][j]);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] q : queries)
            result.add(reachable[q[0]][q[1]]);

        return result;
    }
}