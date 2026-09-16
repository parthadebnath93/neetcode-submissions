class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutation(nums, 0, result);
        return result;
    }
    private void permutation(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permutation(nums, index + 1, result);
            swap(nums, i, index);
        }
    }
    private void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
