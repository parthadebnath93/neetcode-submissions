class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        int maxLength=0;
        int count=1;
        Set<Integer> set=new TreeSet<>();
        for (int i:nums){
            set.add(i);
        }
        int lastNum=Integer.MIN_VALUE;
        for (Integer i:set){
            if (lastNum==Integer.MIN_VALUE){
                maxLength=Integer.max(maxLength,count);
                lastNum=i;
            }else{
                if (i-lastNum==1){
                    count++;
                    maxLength=Integer.max(maxLength,count);
                }else{
                    maxLength=Integer.max(maxLength,count);
                    count=1;
                }
                lastNum=i;
            }
        }
        return maxLength;
    }
}
