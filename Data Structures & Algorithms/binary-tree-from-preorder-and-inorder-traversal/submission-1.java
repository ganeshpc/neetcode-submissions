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
    int[] pre;
    int[] in;
    int n;
    Map<Integer, Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        pre = preorder;
        in = inorder;
        n = preorder.length;
        for (int i=0; i<n; i++) hm.put(in[i], i);
        return build(0, n-1, 0, n-1);
    }

    TreeNode build(int ps, int pe, int is, int ie) {
        if (ps > pe) return null;

        int rootVal = pre[ps];

        int rootIdx = hm.get(rootVal); // findRootIdx(is, ie, rootVal);

        int leftCount = rootIdx - is;
        int rightCount = ie - rootIdx;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(ps+1, ps+leftCount, is, rootIdx-1);
        root.right = build(ps+leftCount+1, pe, rootIdx+1, ie);

        return root;
    }

    int findRootIdx(int is, int ie, int root) {
        for (int i=is; i<=ie; i++) {
            if (in[i] == root) return i;
        }
        return -1;
    }
}
