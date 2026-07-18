class Solution {
    public boolean canJump(int[] nums) {
        int lastIdx = nums.length - 1;

        int max = 0;
        for (int i=0; i<=lastIdx; i++) {

            if (max < i) return false;
            if (max >= lastIdx) return true;

            max = Math.max(max, i+nums[i]);
        }

        return true;
    }
}
