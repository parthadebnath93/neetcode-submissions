class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.merge(ch, 1, Integer::sum);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : map.values()) {
            pq.add(val);
        }
        int time = 0;
        Queue<int[]> q = new ArrayDeque<>();
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int val = pq.poll() - 1;
                if (val > 0) {
                    int[] arr = {val, time + n};
                    q.add(arr);
                }
            }
            if (!q.isEmpty() && time == q.peek()[1]) {
                int[] arr = q.poll();
                pq.add(arr[0]);
            }
        }
        return time;
    }
}
