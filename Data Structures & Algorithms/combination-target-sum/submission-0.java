class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    int n;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        n = nums.length;
        this.nums = nums;
        getSum(0, target, new ArrayList<>());
        return ans; 
    }

    void getSum(int idx, int rem, List<Integer> curr) {
        if (rem == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (idx == n) {
            return;
        }

        if (rem < 0) return;
        getSum(idx+1, rem, curr);
        curr.add(nums[idx]); 
        getSum(idx, rem-nums[idx], curr);
        curr.removeLast();

    }


}
