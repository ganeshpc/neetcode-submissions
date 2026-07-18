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
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
        int max = 0;
        Queue<Integer> pq = new PriorityQueue<>();

        for (Interval intr: intervals) {
            while (!pq.isEmpty() && pq.peek() <= intr.start) pq.remove();

            pq.add(intr.end);

            max = Math.max(max, pq.size());
        }

        return max;
    }
}
