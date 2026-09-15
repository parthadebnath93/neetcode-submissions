class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] result=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            result[i][0]=0;
        }
        for(int j=0;j<n;j++){
            result[0][j]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    result[i][j]=1+result[i-1][j-1];
                }else{
                    result[i][j]=Integer.max(result[i-1][j],result[i][j-1]);
                }
            }
        }
        return result[m][n];
    }
}
