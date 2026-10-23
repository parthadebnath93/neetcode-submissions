class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.merge(i,1,Integer::sum);
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int[] arr={entry.getKey(),entry.getValue()};
            pq.add(arr);
        }
        
        int [] result=new int[k];
        int index=0;
        while(k>0){
            result[index++]=pq.poll()[0];
            k--;
        }
        return result;
    }
}
