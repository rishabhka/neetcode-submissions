class Solution {
    public boolean validTree(int n, int[][] edges) {

        int m = edges.length;
        // cycle check via edge count
        if (m >= n) return false;

        // build adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        // BFS to check connectivity
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neigh : adjList.get(node)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.add(neigh);
                    count++;
                }
            }
        }

        // must visit all nodes
        return count == n;
    }
}
