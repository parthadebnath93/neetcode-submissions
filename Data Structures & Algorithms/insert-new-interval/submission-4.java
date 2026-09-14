class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<List<Integer>> intervalsList = new ArrayList<>();
        for (int[] arr : intervals) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            list.add(arr[1]);
            intervalsList.add(list);
        }
        List<Integer> list = new ArrayList<>();
        list.add(newInterval[0]);
        list.add(newInterval[1]);
        intervalsList.add(list);
        Collections.sort(intervalsList, (a, b) -> a.get(0) - b.get(0));
        List<List<Integer>> resultList = new ArrayList<>();
        list = Arrays.asList(intervalsList.get(0).get(0), intervalsList.get(0).get(1));
        resultList.add(list);
        int lastIndex = 0;
        for (int i = 1; i < intervalsList.size(); i++) {
            if (resultList.get(lastIndex).get(1) < intervalsList.get(i).get(0)) {
                list = Arrays.asList(intervalsList.get(i).get(0), intervalsList.get(i).get(1));
                resultList.add(list);
                lastIndex++;
            } else {
                list = resultList.get(lastIndex);
                int maxElement = Integer.max(list.get(1), intervalsList.get(i).get(1));
                int minElement = Integer.min(list.get(0), intervalsList.get(i).get(0));
                resultList.get(lastIndex).set(0, minElement);
                resultList.get(lastIndex).set(1, maxElement);
            }
        }

        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            int[] num = {resultList.get(i).get(0), resultList.get(i).get(1)};
            result[i] = num;
        }
        return result;
    }
}
