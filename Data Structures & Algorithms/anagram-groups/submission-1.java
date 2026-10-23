class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> list = Arrays.stream(strs)
                                .map(str -> {
                                    char[] arr = str.toCharArray();
                                    Arrays.sort(arr);
                                    return new String(arr);
                                })
                                .collect(Collectors.toList());
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.putIfAbsent(list.get(i), new ArrayList<>());
            map.get(list.get(i)).add(i);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<Integer>l:map.values()){
            result.add(l.stream().map(index->strs[index]).collect(Collectors.toList()));
        }
        return result;
    }
}
