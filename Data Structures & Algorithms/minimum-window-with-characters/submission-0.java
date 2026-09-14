class Solution {
    public String minWindow(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int maxLength = s.length()+1;

        int startIndex = -1;
        Map<Character, Integer> lookup = new HashMap<>();
        for (char ch : t.toCharArray()) {
            lookup.merge(ch, 1, Integer::sum);
        }
        int targetLength = t.length();
        int currentCharLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.merge(ch, 1, Integer::sum);
            if (lookup.containsKey(ch) && map.get(ch) <= lookup.get(ch)) {
                currentCharLength++;
            }
            while (currentCharLength == targetLength) {
                if (maxLength > right - left + 1) {
                    maxLength = right - left + 1;
                    startIndex = left;
                }
                char temp = s.charAt(left);
                if (lookup.containsKey(temp) && map.get(temp) <= lookup.get(temp)) {
                    currentCharLength--;
                }
                map.merge(temp, -1, Integer::sum);
                left++;
            }
        }
        return startIndex < 0 ? "" : s.substring(startIndex, startIndex + maxLength);
    }
}
