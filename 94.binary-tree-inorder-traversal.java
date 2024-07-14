/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();

        //recursive
        // inorder(root, l);

        if(root == null) {
            return l;
        }


        //iterative
        Stack<TreeNode> s = new Stack();
        TreeNode curr = root;

        while(curr != null || !s.isEmpty()) {
            
            //traverse left all elements
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            //no element on left print current element and search right
            curr = s.pop();
            l.add(curr.val);

            curr = curr.right;
        }

        return l;
    }

    public void inorder(TreeNode root, List<Integer> l) {
        if(root == null) {
            return;
        }

        inorder(root.left, l);
        l.add(root.val);
        inorder(root.right, l);
    }
}
// @lc code=end

