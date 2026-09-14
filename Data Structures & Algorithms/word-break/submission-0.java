class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int endIndex = 1; endIndex <= n; endIndex++) {
            for (int i = 0; i < endIndex; i++) {
                if (dp[i] && set.contains(s.substring(i, endIndex))) {
                    dp[endIndex] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
