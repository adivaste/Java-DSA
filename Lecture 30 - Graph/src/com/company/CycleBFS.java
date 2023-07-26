public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
        if (!visited[i] && checkCycle(i, adj, visited)) {
            return true;
        }
    }
    return false;
}

public boolean checkCycle(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
        int top = queue.poll();

        for (int v : adj.get(top)) {
            if (!visited[v]) {
                visited[v] = true;
                queue.add(v);
            } else if (v != top) {
                // If the adjacent node is visited and not the parent, it indicates a cycle.
                return true;
            }
        }
    }
    return false;
}

