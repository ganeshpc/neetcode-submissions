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
    List<Integer> inorder = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        return isValid(root, -2000, 2000);
    }

    boolean isValid(TreeNode root, int low, int high) {
        if (root == null) return true;

        if (root.val <= low || root.val >= high) return false;

        return (isValid(root.left, low, root.val) && isValid(root.right, root.val, high));
    }

    void inorderTrav(TreeNode root) {
        if (root == null) return;

        inorderTrav(root.left);
        inorder.add(root.val);
        inorderTrav(root.right);
    } 
}
