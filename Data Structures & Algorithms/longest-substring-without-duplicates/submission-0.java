class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int maxLength=0;
        int n=s.length();
        Map<Character, Integer> map=new HashMap<>();
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            map.merge(ch, 1, Integer::sum);
            while(map.get(ch)>1){
                char temp=s.charAt(left);
                map.merge(temp,-1,Integer::sum);
                left++;
            }
            maxLength=Integer.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
