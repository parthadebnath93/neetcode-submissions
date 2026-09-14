class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] isVisited = new boolean[n];
        boolean isCycle = dfs(edges, 0, isVisited, -1);
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                return false;
            }
        }
        return !isCycle;
    }
    private boolean dfs(int[][] edges, int node, boolean[] isVisited, int parent) {
        isVisited[node] = true;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (node == u) {
                if (!isVisited[v]) {
                    if (dfs(edges, v, isVisited, node)) {
                        return true;
                    }
                } else if (v != parent) {
                    return true;
                }
            } else if (node == v) {
                if (!isVisited[u]) {
                    if (dfs(edges, u, isVisited, node)) {
                        return true;
                    }
                } else if (u != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
