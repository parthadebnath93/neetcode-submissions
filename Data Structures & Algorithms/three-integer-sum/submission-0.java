class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>>result=new HashSet<>();
        if (nums.length==3){
            if (IntStream.of(nums).sum()==0){
                result.add(Arrays.stream(nums).boxed().toList());
                return result.stream().toList();
            }
        }
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            int start=i+1;
            int end= nums.length-1;
            int sum=0-nums[i];
            while (start<end){
                if (sum==nums[start]+nums[end]){
                    result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++;
                    end--;
                } else if (nums[start]+nums[end]>sum) {
                    end--;
                }else {
                    start++;
                }
            }
        }
        return result.stream().toList();
    }
}
