class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> isVisited = new HashSet<>();
        int count = 1;
        Set<String> lookup = new HashSet<>();
        for (String word : wordList) {
            lookup.add(word);
        }
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        isVisited.add(beginWord);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int k = 0; k < n; k++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return count;
                }
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char tempChar = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch != tempChar) {
                            arr[i] = ch;
                            String s = String.valueOf(arr);
                            if (!s.equals(word) && lookup.contains(s) && !isVisited.contains(s)) {
                                q.add(s);
                                isVisited.add(s);
                            }
                        }
                    }
                    arr[i] = tempChar;
                }
            }
            count++;
        }
        return 0;
    }
}
