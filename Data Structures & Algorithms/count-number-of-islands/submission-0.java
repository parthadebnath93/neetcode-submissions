class Solution {
    int[] row = {1, 0, -1, 0};
    int[] col = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] isVisited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!isVisited[i][j] && grid[i][j]=='1'){
                    bfs(grid,i,j,isVisited,m,n);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int i, int j, boolean[][] isVisited, int m, int n) {
        Queue<Node> q = new ArrayDeque<>();
        Node node = new Node(i, j);
        q.add(node);
        isVisited[i][j] = true;
        while (!q.isEmpty()) {
            node = q.poll();
            int x = node.i;
            int y = node.j;
            for (int k = 0; k < row.length; k++) {
                int newRow = row[k] + x;
                int newCol = col[k] + y;
                if (isSafe(newRow, newCol, m, n) && !isVisited[newRow][newCol] && grid[newRow][newCol] == '1' ) {
                    q.add(new Node(newRow, newCol));
                    isVisited[newRow][newCol] = true;
                }
            }
        }
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