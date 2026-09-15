class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> map = new HashMap<>();
        return getMaxValue(prices, 0, true, map);
    }
    private int getMaxValue(int[] prices, int index, boolean buy, Map<String, Integer> map) {
        if (index >= prices.length) {
            return 0;
        }
        String key = index + "_" + buy;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (buy) {
            map.put(key,
                Integer.max(-prices[index] + getMaxValue(prices, index + 1, !buy, map),
                    getMaxValue(prices, index + 1, buy, map)));
        } else {
            map.put(key,
                Integer.max(prices[index] + getMaxValue(prices, index + 2, !buy, map),
                    getMaxValue(prices, index + 1, buy, map)));
        }
        return map.get(key);
    }
}
