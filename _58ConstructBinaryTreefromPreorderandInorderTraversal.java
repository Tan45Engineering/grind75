import java.util.HashMap;
import java.util.Map;

/*Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.



Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]*/
public class _58ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //create a map to store the indices of elements in the inorder traversal
        //This helps in efficiently finding the position of elements
        //the key is the element, and the value is its index in the inorder array
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        //start the recursive construction
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap){
        //base case: if the subtree is empty, return null
        if(preStart > preEnd){
            return null;
        }

        //the first element in the preorder traversal is the root of the current subtree
        int rootVal = preorder[preStart]; // 3, 9
        TreeNode root = new TreeNode(rootVal);

        //find the index of the root in the inorder traversal
        int rootIndex = inorderMap.get(rootVal); // 0

        //calculate the size of the left subtree
        int leftSubtreeSize = rootIndex - inStart;// 0

        //recursively build the left subtree
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, rootIndex - 1, inorderMap);

        //recursively build the right subtree
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd, inorderMap);

        return root;
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

//preStart: 2
//preEnd: 1
//inStart: 0
//inEnd: 0
//rootVal: 3
