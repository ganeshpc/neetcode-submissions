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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        var temp = root;

        while (temp != null) {
            st.push(temp);
            temp = temp.left;
        }

        while (!st.isEmpty()) {
            
            temp = st.pop();
            arr.add(temp.val);

            if (temp.right == null) continue;

            temp = temp.right;

            while (temp != null) {
                st.push(temp); 
                temp = temp.left;
            }
        }
        System.out.println(arr);
        return arr.get(k-1);
    }
}
