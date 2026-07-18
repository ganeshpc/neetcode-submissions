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
    class Time {
        int time;
        boolean flag;

        Time(int t, boolean f) {
            time = t;
            flag = f;
        }
        public String toString() {
            return "[" + time + " " + flag + " ]";
        }
    }
    public int minMeetingRooms(List<Interval> intervals) {
        List<Time> list = new ArrayList<>();

        for (Interval interval: intervals) {
            list.add(new Time(interval.start, true));
            list.add(new Time(interval.end, false));
        }

        Collections.sort(list, (t1, t2) -> {
            if (t1.time == t2.time) {
                if (t1.flag == true) return 1;
                return -1;
            } 
            return t1.time - t2.time;
        });
        // System.out.println(list);
        int maxCount =0;
        int curr = 0;
        for (int i=0; i<list.size(); i++) {
            Time t= list.get(i);

            if (t.flag) {
                curr++;
                maxCount = Math.max(curr, maxCount);
            } else {
                curr--;
            }
        }
        return maxCount;
    }
}
