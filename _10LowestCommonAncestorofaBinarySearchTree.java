/*Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

 */
public class _10LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if root is null, return null
        //if root matches with either p or q, return the root
        if( root == null || root == p || root == q){
            return root;
        }

        //recursively search for p and q in the left and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 2
        TreeNode right = lowestCommonAncestor(root.right, p, q); // null

        //if one of the subtree doesn't contain the LCA, return other subtree's result
        if(left == null){
            return right;
        }
        if(right == null){
            return left; // 2
        }
        //if both left and right subtree have valid results, the LCA is the current root
        return root;

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// p = 2, q = 4

//time complexity = O(h), h is the height of the tree
