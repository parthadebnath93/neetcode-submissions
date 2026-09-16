class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = IntStream.of(piles).max().getAsInt();
        int result=high;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int hour = 0;
            for (int pile : piles) {
                hour += ((pile+mid-1) / mid);
            }
            if (hour <= h) {
                result=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return result;
    }
}
