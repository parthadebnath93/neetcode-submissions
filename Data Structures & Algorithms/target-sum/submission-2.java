class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return getResult(nums, 0, target, 0, map);
    }
    private int getResult(int[] nums, int index, int target, int sum, Map<String, Integer> map) {
        if (index == nums.length) {
            return target == sum ? 1 : 0;
        }
        String key=index+"_"+sum;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        map.put(key,
            getResult(nums, index + 1, target, sum + nums[index], map)
                + getResult(nums, index + 1, target, sum - nums[index], map));
        return map.get(key);
    }
}
