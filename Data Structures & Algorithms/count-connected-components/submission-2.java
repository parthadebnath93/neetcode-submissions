class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(edges, n, isVisited, i);
                count++;
            }
        }


        return count;
    }

    private void dfs(int[][] edges, int n, boolean[] isVisited, int node) {
        isVisited[node] = true;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (node == u) {
                if (!isVisited[v]) {
                    dfs(edges, n, isVisited, v);
                }
            }else if(node==v){
            
                if (!isVisited[u]) {
                    dfs(edges, n, isVisited, u);
                }

            }
        }
    }
}
