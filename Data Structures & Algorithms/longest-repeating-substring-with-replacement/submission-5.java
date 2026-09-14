class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = Integer.MIN_VALUE;
        int left = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.merge(ch, 1, Integer::sum);
            maxFreq = Integer.max(maxFreq, map.get(ch));
            if ((right - left + 1) - maxFreq > k) {
                map.merge(s.charAt(left), -1, Integer::sum);
                left++;
            }
            maxLength = Integer.max(maxLength, right - left + 1);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
