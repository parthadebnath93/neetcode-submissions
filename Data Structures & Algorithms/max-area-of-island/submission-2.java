class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] isVisited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!isVisited[i][j] && grid[i][j]==1){
                    maxArea=Integer.max(maxArea,bfs(grid,i,j,m,n,isVisited));
                }
            }
        }
        return maxArea;
    }
    int[] row={1,-1,0,0};
    int[] col={0,0,-1,1};
    private int bfs(int[][] grid, int i, int j, int m, int n, boolean[][]isVisited){
        Queue<int[]> q=new ArrayDeque<>();
        int count=1;
        int[] arr={i,j};
        isVisited[i][j]=true;
        q.add(arr);
        while(! q.isEmpty()){
            // count++;
            int size=q.size();
            // while(size-->0){
                arr=q.poll();
                for(int k=0;k<row.length;k++){
                    int newRow=row[k]+arr[0];
                    int newCol=col[k]+arr[1];
                    if(isSafe(newRow,newCol,m,n) && !isVisited[newRow][newCol] && grid[newRow][newCol]==1){
                        int[] nums={newRow, newCol};
                        q.add(nums);
                        isVisited[newRow][newCol]=true;
                        count++;
                    }
                }
            // }
        }
        return count;
    }
    private boolean isSafe(int i, int j, int m, int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
}
