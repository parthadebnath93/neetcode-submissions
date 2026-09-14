class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);


        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list=Arrays.asList(intervals[0][0],intervals[0][1]);
        resultList.add(list);
        int lastIndex=0;
        for(int i=1;i<intervals.length;i++){
            if(resultList.get(lastIndex).get(1)<intervals[i][0]){
                resultList.add(Arrays.asList(intervals[i][0],intervals[i][1]));
                lastIndex++;
            }else{
                list=resultList.get(lastIndex);
                int minElement=Integer.min(list.get(0),intervals[i][0]);
                int maxElement=Integer.max(list.get(1), intervals[i][1]);
                resultList.get(lastIndex).set(0,minElement);
                resultList.get(lastIndex).set(1,maxElement);

            }
        }

        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            int[] arr = {resultList.get(i).get(0), resultList.get(i).get(1)};
            result[i] = arr;
        }
        return result;
    }
}
