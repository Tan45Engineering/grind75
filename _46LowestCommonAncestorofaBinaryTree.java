/*Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”



Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.*/
public class _46LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case: if the root is null or equal to either p or q, it is the LCA
        if(root == null || root == p || root == q){
            return root;
        }

        //recursively search for LCA in the left and right subtress
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q); // 5
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q); // null

        //if both left and right subtress have LCA, the root is the LCA
        if(leftLCA != null && rightLCA != null){
            return root;
        }

        //if only one subtree has LCA, return that LCA
        return (leftLCA != null) ? leftLCA: rightLCA;
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
