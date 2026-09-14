class Solution {
    static class Pair {
        int element;
        int count;

        public Pair(int element, int count) {
            this.element = element;
            this.count = count;
        }

        @Override
        public int hashCode() {
            return ((Integer)element).hashCode();
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "element=" + element +
                    ", count=" + count +
                    '}';
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
         Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.count-o2.count;
            }
        });
        for (int i : nums) {
            map.merge(i, 1, Integer::sum);
        }
        for (int i:map.keySet()){
            pq.add(new Pair(i,map.get(i)));
            while (pq.size()>k){
                pq.poll();
            }
        }
        int[] result=new int[k];
       return pq.stream().map(pair->pair.element).mapToInt(Integer::intValue).toArray();
    }
}
