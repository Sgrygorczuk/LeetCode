package com.leet_code.game.problems;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 * Example 3:
 *
 * Input: root = []
 * Output: 0
 * Example 4:
 *
 * Input: root = [0]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() { }

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class P104 {
    public int maxDepth(TreeNode root) {
        //In case the root is empty
        if(root == null){return 0;}
        //In case the root has no children
        else if(root.left == null && root.right == null){ return 1; }
        else {
            //The max function compares the output of the two sides
            //We recursively check which one is taller by checking it's children
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
