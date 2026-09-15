class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int maxResult = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = maxSoFar;
            maxSoFar = Integer.max(nums[i], Integer.max(nums[i] * maxSoFar, nums[i] * minSoFar));
            minSoFar = Integer.min(nums[i], Integer.min(nums[i] * temp, nums[i] * minSoFar));
            maxResult = Integer.max(maxSoFar, maxResult);
        }
        return maxResult;
    }
}
