class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp) && map.get(temp) != i){
                int index=map.get(temp);
                if(index>i){
                    int[] arr={i,index};
                    return arr;
                }else{
                int[] arr={map.get(temp),i};
                return arr;
                }
            }
        }
        return new int[2];
    }
}
