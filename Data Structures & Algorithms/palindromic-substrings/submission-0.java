class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<(n*2)-1;i++){
            int left=i/2;
            int right=(i+1)/2;
            while(left>=0 && right < n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                count++;
            }
        }
        return count;
    }
}
