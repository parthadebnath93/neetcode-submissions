class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> map=new HashMap<>();
        int firstValue=getValue(cost, 0,map);
        map=new HashMap<>();
        int secValue=getValue(cost,1,map);
        return Integer.min(firstValue, secValue);
    }
    private int getValue(int[] cost, int index, Map<Integer, Integer> map){
        if(index>=cost.length){
            return 0;
        }
        if(map.containsKey(index)){
            return map.get(index);
        }
        int val=cost[index];
        int withOneJump=getValue(cost, index+1,map);
        int withTwoJump=getValue(cost, index+2,map);
        map.put(index, Integer.min(withOneJump, withTwoJump)+val);
        return map.get(index);
    }
}
