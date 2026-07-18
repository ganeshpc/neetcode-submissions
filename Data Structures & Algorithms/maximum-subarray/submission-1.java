class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int max = nums[0];
        int sum = 0;
        for (int num: nums) {
            sum += num;
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }

        return max;
    }
}
