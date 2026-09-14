class MinStack {
    TreeMap<Integer, List<Integer>> map;
    List<Integer> list;
    
    public MinStack() {
        this.map=new TreeMap<>();
        this.list=new ArrayList<>();    
    }
    
    public void push(int val) {
        list.add(val);
        map.putIfAbsent(val, new ArrayList<>());
        map.get(val).add(list.size()-1);
    }
    
    public void pop() {
        int val=list.get(list.size()-1);
        list.remove(list.size()-1);
        if(map.get(val).size()==1){
            map.remove(val);
        }else{
            List<Integer> arr=map.get(val);
            arr.remove(arr.size()-1);
            map.put(val,arr);
        }
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
       return map.firstKey();
    }
}
