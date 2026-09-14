class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] result=new boolean[n+1];
        Set<String> set=new HashSet<>(wordDict);
        result[0]=true;
        for(int index=1;index<=n;index++){
            for(int j=0;j<index;j++){
                if(result[j] && set.contains(s.substring(j,index))){
                    result[index]=true;
                    break;
                }

            }
        }
        return result[n];
    }
}
