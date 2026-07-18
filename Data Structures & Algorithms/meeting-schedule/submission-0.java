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
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.end));

        int n = intervals.size();

        for (int i=0; i<n-1; i++) {
            int endFirst = intervals.get(i).end;
            int startSecond = intervals.get(i+1).start;

            if (startSecond < endFirst) return false;
        }
        return true;
    }
}
