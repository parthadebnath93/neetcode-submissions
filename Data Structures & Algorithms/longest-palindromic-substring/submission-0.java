class Solution {
    public String longestPalindrome(String s) {
        String maxString="";
        int maxLength=0;
        int currLength=0;
        String currString="";
        for(int i=0;i<s.length();i++){
            currString=getPalindrome(s,i,i);
            currLength=currString.length();
            if(maxLength<currLength){
                maxLength=currLength;
                maxString=currString;
            }
            currString=getPalindrome(s,i,i+1);
            currLength=currString.length();
            if(maxLength<currLength){
                maxLength=currLength;
                maxString=currString;
            }
        }
        return maxString;
    }
    private String getPalindrome(String str, int low, int high){
        while(low>=0 && high<str.length() && str.charAt(low)==str.charAt(high)){
            low--;
            high++;
        }
        return str.substring(low+1,high);
    }
    
}
