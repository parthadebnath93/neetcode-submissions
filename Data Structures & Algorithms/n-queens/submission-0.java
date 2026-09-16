class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        char[][] mat=new char[n][n];
        for(char[] arr:mat){
            Arrays.fill(arr,'.');
        }
        nQueen(mat,0,result);
        return result;
    }
    private boolean isSafe(char[][] mat, int r, int c){
        for(int i=0;i<r;i++){
            if(mat[i][c]=='Q'){
                return false;
            }
        }
        for(int i=r,j=c; i>=0 && j>=0;i--,j--){
            if(mat[i][j]=='Q'){
                return false;
            }
        }
        for(int i=r,j=c ; i>=0 && j<mat.length;i--,j++){
            if(mat[i][j]=='Q'){
                return false;
            }
        }


        return true;
    }
    private void nQueen(char[][] mat, int r, List<List<String>> result){
        if(r==mat.length){
            List<String> list=new ArrayList<>();
            for(char[] arr:mat){
                list.add(String.valueOf(arr));
            }
            result.add(list);
            return;
        }
        for(int i=0;i<mat.length;i++){
            if(isSafe(mat,r,i)){
                mat[r][i]='Q';
                nQueen(mat, r+1,result);
                mat[r][i]='.';
            }
        }
    }
}
