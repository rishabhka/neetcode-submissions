class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Min-heap per airport so we always take the lex-smallest next hop
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> t : tickets) {
            adj.computeIfAbsent(t.get(0), k -> new PriorityQueue<>())
               .add(t.get(1));
        }

        LinkedList<String> route = new LinkedList<>();
        dfs("JFK", adj, route);
        return route;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> adj,
                     LinkedList<String> route) {
        PriorityQueue<String> dests = adj.get(airport);
        while (dests != null && !dests.isEmpty()) {
            String next = dests.poll();   // consume the ticket
            dfs(next, adj, route);
        }
        route.addFirst(airport);          // add on the way OUT (post-order)
    }
}