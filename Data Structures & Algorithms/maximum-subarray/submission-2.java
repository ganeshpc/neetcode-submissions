class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curr = maxSum;

        int n = nums.length;
        for (int i=1; i<n; i++) {
            curr = Math.max(curr+nums[i], nums[i]);
            maxSum = Math.max(maxSum, curr);
        }
        return maxSum;
    }
}
