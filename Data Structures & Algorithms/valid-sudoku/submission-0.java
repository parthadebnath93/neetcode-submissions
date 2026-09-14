class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> rowSet = new HashSet<>();
        Set<String> colSet = new HashSet<>();
        Set<String> boxSet = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    String rowKey = "row_" + i + "_" + board[i][j];
                    if (rowSet.contains(rowKey)) {
                        return false;
                    }
                    rowSet.add(rowKey);
                    String colKey = "col_" + j + "_" + board[i][j];
                    if (colSet.contains(colKey)) {
                        return false;
                    }
                    colSet.add(colKey);
                    String boxKey = "box_" + (i/ 3) + "_" + (j / 3) + "_" + board[i][j];
                    if (boxSet.contains(boxKey)) {
                        return false;
                    }
                    boxSet.add(boxKey);
                }
            }
        }
        return true;
    }
}
