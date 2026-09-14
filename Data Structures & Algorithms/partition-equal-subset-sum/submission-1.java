class Solution {
    public boolean canPartition(int[] nums) {
        int sum=IntStream.of(nums).sum();
        if(sum%2 !=0){
            return false;
        }
        Map<String, Boolean> map=new HashMap<>();
        return isPartitionPossible(nums,0,sum/2, map);
    }
    private boolean isPartitionPossible(int[] nums, int index, int sum, Map<String, Boolean> map){
        if(index==nums.length){
            if(sum==0){
                return true;
            }
            return false;
        }
        String key=index+"_"+sum;
        if(map.containsKey(key)){
            return map.get(key);
        }
        boolean include=isPartitionPossible(nums, index+1,sum-nums[index], map);
        boolean exclude=isPartitionPossible(nums,index+1,sum, map);
        map.put(key, include || exclude);
        return map.get(key);
    }
}
