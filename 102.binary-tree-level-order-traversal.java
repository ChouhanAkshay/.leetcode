/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) {
            return ll;
        }

        q.add(root);

        while(!q.isEmpty()){
            int qSize = q.size();
            List<Integer> l = new ArrayList<>();

            for(int i = 0 ; i < qSize ; i++) {
                TreeNode num = q.poll();
                l.add(num.val);

                if(num.left != null) {
                    q.add(num.left);
                }

                if(num.right != null) {
                    q.add(num.right);
                }
            }

            ll.add(l);
        }


        return ll;
    }
}
// @lc code=end

