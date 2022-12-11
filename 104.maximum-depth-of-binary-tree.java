/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start
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
    int res = 0; // record of the maxDepth
    int depth = 0; // record the depth to the current node

    public int maxDepth(TreeNode root) {
        traverse(root);        
        return res;
    }

    void traverse(TreeNode root) {
        if(root == null) return;
        // preOrder ------
        depth++;
        if(root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        // ------ preOrder
        traverse(root.left);
        // ------midOrder
        traverse(root.right);
        // postOrder
        depth--;
    }

    // int maxDepth(TreeNode root) {
    //     if (root == null) {
    //     return 0;
    //     }
    //     int leftMax = maxDepth(root.left);
    //     int rightMax = maxDepth(root.right);
    //     int res = Math.max(leftMax, rightMax) + 1;
    //     return res;
    // }
}
// @lc code=end

