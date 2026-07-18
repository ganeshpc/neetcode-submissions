class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();     
        for (int num: nums) hs.add(num);
        int max = 0;
        for (int num: nums) {
            if (!hs.contains(num)) continue;
            if (hs.contains(num-1)) continue;

            int count = 0;
            while (hs.contains(num)) {
                hs.remove(num);
                count++;
                num++;
            }

            max = Math.max(count, max);
        }
        return max;
    }
}
