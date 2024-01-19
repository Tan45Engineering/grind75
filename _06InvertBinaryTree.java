/*Given the root of a binary tree, invert the tree, and return its root.
        Input: root = [4,2,7,1,3,6,9]
        Output: [4,7,2,9,6,3,1]*/

public class _06InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {//4
        //Base condition: If the root is null, return null
        if(root == null){
            return null;
        }

        //Invert the left subtree by calling the function recursively
        TreeNode left = invertTree(root.left);// 2
        //Invert the right subtree by calling the function recursively
        TreeNode right = invertTree(root.right);// 7

        //swap left and right subtrees
        root.left = right; // 7
        root.right = left; // 2

        //return the root node of the inverted tree
        return root;

    }
}

/**
 * Definition for a binary tree node.
 */
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
