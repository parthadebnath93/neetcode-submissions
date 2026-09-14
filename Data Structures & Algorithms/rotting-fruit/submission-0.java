class Solution {
    int[] row = {1, -1, 0, 0};
    int[] col = {0, 0, -1, 1};
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Node> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }
        int time = 0;
        while (!q.isEmpty() && freshCount>0) {
            time++;
            int size = q.size();
            while (size > 0) {
                size--;
                Node node = q.poll();
                for (int k = 0; k < row.length; k++) {
                    int newRow = row[k] + node.i;
                    int newCol = col[k] + node.j;
                    if (isSafe(newRow, newCol, m, n) && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        q.add(new Node(newRow, newCol));
                        freshCount--;
                    }
                }
            }
        }
        for (int[] arr : grid) {
            System.out.println(Arrays.toString(arr));
        }
        return freshCount > 0 ? -1 : time;
    }
    private boolean isSafe(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
class Node {
    int i, j;
    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}