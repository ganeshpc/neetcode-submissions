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
        inorderTrav(root);    

        for (int i=1; i<inorder.size(); i++) {
            if (inorder.get(i-1) >= inorder.get(i)) return false;
        }

        return true;
    }

    void inorderTrav(TreeNode root) {
        if (root == null) return;

        inorderTrav(root.left);
        inorder.add(root.val);
        inorderTrav(root.right);
    } 
}
