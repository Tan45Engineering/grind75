/*Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.



Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1*/
public class _66KthSmallestElementinaBST {
    //global variable to keep track of the count
    private int count;
    public int kthSmallest(TreeNode root, int k) {
        //initialize count before the recursive calls
        count = 0;

        //start the in-order Traversal till we find the kth smallest element
        return inOrderTraversal(root, k);
    }

    //recursive function for in-order traversal
    private int inOrderTraversal(TreeNode node, int k){
        //base case: if node is null, return -1
        if(node == null){
            return -1;
        }

        //traverse the left subtree
        int leftResult = inOrderTraversal(node.left, k);

        //if the left subtree contains the kth smallest
        if(leftResult != -1){
            return leftResult;
        }

        //increment the count as we visit the current node
        count++;// 1 2 3

        //check if the current node is the kth smallest
        if(count == k){
            return node.val;
        }

        //traverse the right subtree
        return inOrderTraversal(node.right, k);
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
