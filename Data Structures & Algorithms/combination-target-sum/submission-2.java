class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums; int target;
    int n;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        n = nums.length;

        rec(0, new ArrayList<>(), 0);

        return ans;
    }

    void rec(int idx, List<Integer> curr, int sum) {
        if (idx == n) return;
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        rec(idx+1, curr, sum);
        curr.add(nums[idx]);

        rec(idx, curr, sum+nums[idx]);
        curr.removeLast();
    }
}
