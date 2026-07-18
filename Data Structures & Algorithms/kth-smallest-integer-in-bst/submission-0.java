/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int curr = 1;
    int ans = -1;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        recurse(root);
        return ans;
    }

    void recurse(TreeNode root) {
        if (root == null) return;

        recurse(root.left);
        // System.out.println("curr: " + curr + " val: " + root.val);
        if (k == curr) ans = root.val;
        curr++;
        recurse(root.right);
    }
}
