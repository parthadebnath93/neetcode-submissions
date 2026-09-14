class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] isVisited = new boolean[n];
        boolean isCycle = dfs(0, edges, isVisited, -1);
        
        // Check if all nodes are visited (connectivity)
        for (boolean flag : isVisited) {
            if (!flag) {
                return flag;
            }
        }
        return !isCycle;
    }
    
    private boolean dfs(int node, int[][] edges, boolean[] isVisited, int parent) {
        isVisited[node] = true;
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            // Check if current node is u (first direction)
            if (node == u) {
                if (!isVisited[v]) {
                    if (dfs(v, edges, isVisited, node)) {
                        return true;
                    }
                } else if (v != parent) {  // ✓ FIX: v != parent, not u
                    return true;  // Cycle detected
                }
            }
            // Check if current node is v (reverse direction for undirected edge)
            else if (node == v) {  // ✓ FIX: Handle reverse direction
                if (!isVisited[u]) {
                    if (dfs(u, edges, isVisited, node)) {
                        return true;
                    }
                } else if (u != parent) {
                    return true;  // Cycle detected
                }
            }
        }
        return false;
    }
}