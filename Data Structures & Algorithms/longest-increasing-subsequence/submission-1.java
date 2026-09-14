class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        Map<String, Integer> map=new HashMap<>();
        return getValue(nums, 0, Integer.MIN_VALUE, n, map);
    }
    private int getValue(int[] nums, int index, int prev, int n, Map<String, Integer> map){
        if(index==n){
            return 0;
        }
        String key=index+"_"+prev;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int include=0;
        if(nums[index]>prev){
            include=1+getValue(nums, index+1, nums[index],n,map);
        }
        int exclude=getValue(nums, index+1, prev, n,map);
        map.put(key,Integer.max(include, exclude));
        return map.get(key);
    }
}
