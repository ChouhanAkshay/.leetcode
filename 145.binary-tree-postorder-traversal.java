/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();

        //recursive
        // postOrder(root, l);

        //iterative - 1 stack
        // Stack<TreeNode> s = new Stack();
        // TreeNode curr = root;

        // if(root == null){
        //     return l;
        // }

        // while(true) {

        //     while(curr != null) {
        //         s.push(curr);
        //         s.push(curr);
        //         curr = curr.left;
        //     }

        //     if(s.isEmpty()) return l;

        //     //new curr value after prev. was null
        //     curr = s.pop();

        //     if(!s.isEmpty() && curr == s.peek())
        //         curr = curr.right;
        //     else {
        //         l.add(curr.val);
        //         curr = null;
        //     }
        // }

        //iterative - 2 stack
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        if(root == null) {
            return l;
        }

        s1.push(root);

        while(!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);

            if(node.left != null) {
                s1.push(node.left);
            }

            if(node.right != null) {
                s1.push(node.right);
            }
        }

        while(!s2.empty()) {
            l.add(s2.pop().val);
        }

        return l;
    }

    public void postOrder(TreeNode root, List<Integer> l) {
        if(root == null) {
            return ;
        }

        postOrder(root.left, l);
        postOrder(root.right, l);
        l.add(root.val);
    }
}
// @lc code=end

