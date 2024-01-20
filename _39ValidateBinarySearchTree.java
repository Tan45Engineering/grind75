/*Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/
public class _39ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        //use long.MIN_VALUE and Long.MAX_VALUE to handle edge cases with Integer.MIN_VALUE and Integer.MAX_VALUE
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long minValue, long maxValue){
        //base case: check for null
        if(node == null){
            return true;
        }

        //check if the current node's value is within the range
        if(node.val <= minValue || node.val >= maxValue){
            return false;
        }

        //recursively check the left and right subtrees
        return isValidBSTHelper(node.left, minValue, node.val) && isValidBSTHelper(node.right, node.val, maxValue);
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
