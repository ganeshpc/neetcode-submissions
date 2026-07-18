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
    public int minMeetingRooms(List<Interval> intervals) {

        int n = intervals.size();

        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));

        Queue<Integer> endTimes = new PriorityQueue<>();

        for (Interval interval: intervals) {
            
            if (endTimes.isEmpty()) {
                endTimes.add(interval.end);
            } else {
                if (endTimes.peek() <= interval.start) {
                    endTimes.remove();
                } 
                endTimes.add(interval.end);
            }
        }

        return endTimes.size();
    }
}
