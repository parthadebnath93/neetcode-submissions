class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        Queue<Node> pacific=new ArrayDeque<>();
        boolean[][] pacificIsVisited=new boolean[m][n];
        Queue<Node> atlantic=new ArrayDeque<>();
        boolean[][]atlanticIsVisited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    pacific.add(new Node(i,j));
                    pacificIsVisited[i][j]=true;
                }
                if(i==m-1 || j==n-1){
                    atlantic.add(new Node(i,j));
                    atlanticIsVisited[i][j]=true;
                }
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        bfs(heights,pacific,m,n,pacificIsVisited);
        bfs(heights,atlantic,m,n,atlanticIsVisited);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacificIsVisited[i][j] && atlanticIsVisited[i][j]){
                    List<Integer> list=Arrays.asList(i,j);
                    result.add(list);
                }
            }
        }
        return result;
    }
    int[] row={0,0,-1,1};
    int[] col={1,-1,0,0};
    private void bfs(int[][] heights,Queue<Node>q, int m, int n, boolean[][] isVisited){
        while(!q.isEmpty()){
            Node node=q.poll();
            for(int k=0;k<row.length;k++){
                int newRow=row[k]+node.i;
                int newCol=col[k]+node.j;
                if(isSafe(newRow, newCol,m,n) && !isVisited[newRow][newCol] && heights[newRow][newCol]>=heights[node.i][node.j]){
                    isVisited[newRow][newCol]=true;
                    q.add(new Node(newRow, newCol));
                }
            }
        }
    }
    private boolean isSafe(int i,int j, int m, int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
}
class Node{
    int i,j;
    public Node(int i, int j){
        this.i=i;
        this.j=j;
    }
}
