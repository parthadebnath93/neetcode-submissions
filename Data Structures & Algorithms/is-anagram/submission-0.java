class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer>map=new HashMap<Character,Integer>();
        for(char ch:s.toCharArray()){
            map.merge(ch,1,Integer::sum);
        }
        for(char ch:t.toCharArray()){
            map.merge(ch,-1,Integer::sum);
        }
        for(int i:map.values()){
            if(i<0 || i>0){
                return false;
            }
        }
        return true;
    }
}
