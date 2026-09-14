class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        Queue<int[]> pacific = new ArrayDeque<>();
        boolean[][] pacificIsVisited = new boolean[m][n];
        Queue<int[]> atlantic = new ArrayDeque<>();
        boolean[][] atlanticIsVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    int[] arr = {i, j};
                    pacific.add(arr);
                    pacificIsVisited[i][j] = true;
                }
                if (i == m - 1 || j == n - 1) {
                    int[] nums = {i, j};
                    atlantic.add(nums);
                    atlanticIsVisited[i][j] = true;
                }
            }
        }
        bfs(heights, pacific, pacificIsVisited, m, n);
        bfs(heights, atlantic, atlanticIsVisited, m, n);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificIsVisited[i][j] && atlanticIsVisited[i][j]) {
                    List<Integer> list = Arrays.asList(i, j);
                    result.add(list);
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] isVisited, int m, int n) {
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            for (int k = 0; k < row.length; k++) {
                int i = row[k] + arr[0];
                int j = col[k] + arr[1];
                if (isSafe(i, j, m, n) && !isVisited[i][j] && heights[i][j] >= heights[arr[0]][arr[1]]) {
                    isVisited[i][j] = true;
                    int[] nums = {i, j};
                    q.add(nums);
                }
            }
        }
    }

    

    int[] row = {0, 0, 1, -1};
    int[] col = {1, -1, 0, 0};
    private boolean isSafe(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
