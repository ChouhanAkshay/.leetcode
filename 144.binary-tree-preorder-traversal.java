/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();

        //recursive
        // preorder(root, l);

        //iterative
        Stack<TreeNode> s = new Stack();

        if(root == null) {
            return l;
        }

        s.push(root);

        while(!s.isEmpty()) {
            TreeNode node = s.pop();

            l.add(node.val);

            if(node.right != null) {
                s.push(node.right);
            }

            if(node.left != null) {
                s.push(node.left);
            }
        }

        return l;
    }

    public void preorder(TreeNode root, List<Integer> l) {
        if(root == null) {
            return;
        }

        l.add(root.val);
        preorder(root.left, l);
        preorder(root.right, l);
    }
}
// @lc code=end

