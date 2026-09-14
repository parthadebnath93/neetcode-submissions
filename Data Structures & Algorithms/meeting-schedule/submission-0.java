/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)->a.start-b.start);
        int lastIndex=0;
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(lastIndex).end>intervals.get(i).start){
                return false;
            }else{
                lastIndex++;
            }
        }
        return true;
    }
}
