/*Given a binary tree, determine if it is
height-balanced
.*/
public class _11BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        //Base case: If the root is null, it is height balanced by definition
        if(root == null){
            return true;
        }

        //check if the height difference of the left and right subtre is not more than 1
        boolean isHeightBalanced = Math.abs(height(root.left) - height(root.right)) <= 1;

        //check recursively if both the left and right subtrees are balanced
        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);

        return isHeightBalanced && leftBalanced && rightBalanced;

    }

    public int height(TreeNode root){
        //base case: if the root is null, height is 0
        if(root == null){
            return 0;
        }

        //recursively calculate the height of the tree as the maximum height of its left and right subtree, plus 1 for the current node
        return Math.max(height(root.left), height(root.right)) + 1;
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
