class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int start = -1;
        int n = nums.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < k - 1; i++) {
            int[] arr = {i, nums[i]};
            q.offer(arr);
        }
        // result[0] = q.peek()[1];
        for (int i = k - 1; i < n; i++) {
            int[] arr = {i, nums[i]};
            q.offer(arr);
            while (q.peek()[0] <= i - k) {
                q.poll();
            }
            result[i - k + 1] = q.peek()[1];
        }
        return result;
    }
}
