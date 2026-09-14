class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        Queue<Integer> q=new ArrayDeque<>();
        Set<Integer> isVisited=new HashSet<>();
        q.add(0);
        isVisited.add(0);
        int count=0;
        while(!q.isEmpty()){
            int n=q.size();
            count++;
            for(int i=0;i<n;i++){
                int currAmount=q.poll();
                for(int coin:coins){
                    int nextVal=currAmount+coin;
                    if(nextVal==amount){
                        return count;
                    }
                    if(nextVal<amount && !isVisited.contains(nextVal)){
                        isVisited.add(nextVal);
                        q.add(nextVal);
                    }
                }
            }
        }
        return -1;
    }
}
