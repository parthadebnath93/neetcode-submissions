class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> list= Arrays.stream(strs).map(str->{char[] arr=str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
        }).collect(Collectors.toList());
        Map<String,List<Integer>> map=new HashMap<>();
        for (int i=0;i< list.size();i++){
            map.putIfAbsent(list.get(i),new ArrayList<>() );
            map.get(list.get(i)).add(i);
        }
        System.out.println(map);
        List<List<String>> result=new ArrayList<>();
        for (List<Integer> array:map.values()){
           result.add( array.stream().map(i->strs[i]).collect(Collectors.toList()));
        }
        return result;
    }
}
