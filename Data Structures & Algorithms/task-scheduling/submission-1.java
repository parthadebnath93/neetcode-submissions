class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map=new HashMap<>();
        for(char ch:tasks){
            map.merge(ch,1,Integer::sum);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(Integer count:map.values()){
            pq.add(count);
        }
        Queue<int[]> q=new ArrayDeque<>();
        int time=0;
        while(! pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
            int count=pq.poll()-1;
            if(count >0){
                int[] arr={count,time+n};
                q.add(arr);
            }
            }
            if(!q.isEmpty() && q.peek()[1]==time){
                int[] arr=q.poll();
                pq.add(arr[0]);
            }
        }
        return time;
    }
}
