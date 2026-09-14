class Solution {
    
    public  boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> lookup = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            lookup.merge(ch, 1, Integer::sum);
        }
        int low = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            map.merge(ch, 1, Integer::sum);
            while (low < s2.length() && i - low+1 > s1.length()) {
                char temp = s2.charAt(low);
                map.merge(temp, -1, Integer::sum);
                if(map.get(temp)==0){
                    map.remove(temp);
                }
                low++;
            }
            if (i - low+1 != s1.length()) {
                continue;
            }
            boolean flag = true;
            for (Character temp : map.keySet()) {
                if (lookup.containsKey(temp)) {
                    if (map.get(temp) == lookup.get(temp)) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}