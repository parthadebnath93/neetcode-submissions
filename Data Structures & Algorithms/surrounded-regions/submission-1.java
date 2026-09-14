class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean [][] isVisited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j]=='O' && !isVisited[i][j]){
                    bfs(board,i,j,m,n,isVisited);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!isVisited[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    private void bfs(char[][] board, int i, int j, int m, int n, boolean[][] isVisited){
        Queue<Node> q=new ArrayDeque<>();
        q.add(new Node(i,j));
        isVisited[i][j]=true;

        while(!q.isEmpty()){
            Node node=q.poll();
            for(int k=0;k<row.length;k++){
                int newRow=node.i+row[k];
                int newCol=node.j+col[k];
                if(isSafe(newRow, newCol,m,n) && !isVisited[newRow][newCol] && board[newRow][newCol]=='O'){
                    q.add(new Node(newRow,newCol));
                    isVisited[newRow][newCol]=true;
                }
            }
        }
    }
    int[] row={1,-1,0,0};
    int[] col={0,0,1,-1};
    private boolean isSafe(int i, int j, int m, int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
}
class Node{
    int i,  j;
    public Node(int i, int j){
        this.i=i;
        this.j=j;
    }
}
