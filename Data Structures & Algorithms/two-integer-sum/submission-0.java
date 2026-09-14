class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>set=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(set.get(temp)!=null){
                return new int[]{set.get(temp),i};
            }
            set.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
