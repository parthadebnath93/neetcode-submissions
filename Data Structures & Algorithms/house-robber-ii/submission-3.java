class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Integer.max(nums[0],nums[1]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int val1 = getMaxValue(nums, 0, n - 2, map);
        map = new HashMap<>();
        int val2 = getMaxValue(nums, 1, n - 1, map);
        return Integer.max(val1, val2);
    }

    private int getMaxValue(int[] nums, int index, int end, Map<Integer, Integer> map) {
        if (index > end) {
            return 0;
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }
        int include = getMaxValue(nums, index + 2, end, map) + nums[index];
        int exclude = getMaxValue(nums, index + 1, end, map);
        map.put(index, Integer.max(include, exclude));
        return map.get(index);
    }
}
