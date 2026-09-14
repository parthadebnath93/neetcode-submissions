class Solution {
    public int numDecodings(String s) {
        Integer[] arr = new Integer[s.length()];
        return getResult(s, arr, 0);
    }
    private Integer getResult(String s, Integer[] arr, int index) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (arr[index] != null) {
            return arr[index];
        }
        Integer result = getResult(s, arr, index + 1);
        if (index + 1 < s.length()) {
            Integer val = Integer.valueOf(s.substring(index, index + 2));
            if (val >= 10 && val <= 26) {
                result += getResult(s, arr, index + 2);
            }
        }
        return arr[index] = result;
    }
}
