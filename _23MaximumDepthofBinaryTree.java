/*Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Input: root = [3,9,20,null,null,15,7]
Output: 3*/
public class _23MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        //base case: if the root is null, depth is 0
        if(root == null){
            return 0;
        }

        //base case: if the root  is a leaf node, the depth is 1
        if(root.left == null && root.right == null){
            return 1;
        }

        //recursively find the maximum depth of the left and right subtrees
        int leftDepth = maxDepth(root.left); // 1
        int rightDepth = maxDepth(root.right); // 2

        //return the maximum depth of the current subtree (add 1 for the current node)
        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1); //3

    }
}

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
