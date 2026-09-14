class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] isVisited=new boolean[m][n];
        Queue<Node> q=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.add(new Node(i,j,0));
                    isVisited[i][j]=true;
                }
            }
        }
        bfs(grid,isVisited,m,n,q);
    }
    int[] row={1,-1,0,0};
    int[] col={0,0,-1,1};
    private void bfs(int[][] grid, boolean[][] isVisited, int m, int n, Queue<Node> q){
        while(!q.isEmpty()){
            Node node=q.poll();
            for(int k=0;k<row.length;k++){
                int newRow=row[k]+node.i;
                int newCol=col[k]+node.j;
                if(isSafe(newRow, newCol, m,n)){
                    if(!isVisited[newRow][newCol] && grid[newRow][newCol]==Integer.MAX_VALUE){
                        grid[newRow][newCol]=node.val+1;
                        isVisited[newRow][newCol]=true;
                        q.add(new Node(newRow,newCol,node.val+1));
                    }else if(isVisited[newRow][newCol] && grid[newRow][newCol]!=-1 && grid[newRow][newCol]>node.val+1){
                        grid[newRow][newCol]=node.val+1;
                    }
                }
            }
        }
    }
    private boolean isSafe(int i, int j, int m,int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
}
class Node{
    int i,j,val;
    public Node(int i, int j, int val){
        this.i=i;
        this.j=j;
        this.val=val;
    }
}
