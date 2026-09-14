class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        return getMaxValue(nums, 0, map);
    }

    private int getMaxValue(int[] nums, int index, Map<Integer, Integer> map){
        if(index>=nums.length){
            return 0;
        }
        if(map.containsKey(index)){
            return map.get(index);
        }
        int include=nums[index]+getMaxValue(nums, index+2,map);
        int exclude=getMaxValue(nums, index+1,map);
        map.put(index, Integer.max(include, exclude));
        return map.get(index);
    }
}
