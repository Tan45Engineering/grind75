import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.



Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
*/
public class _55BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //base case
        if(root == null){
            return result;
        }

        //use a queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();// 1, 2, 2

            //traverse each level and add the rightmost node to the result list
            for(int i = 0; i < levelSize; i++){
                TreeNode current = queue.poll();

                //check for right most child node
                if(i == levelSize-1){
                    result.add(current.val);
                }

                //check for left child
                if(current.left != null){
                    queue.offer(current.left);
                }

                //check for right child
                if(current.right != null){
                    queue.offer(current.right);
                }
            }
        }

        return result;
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

//Queue:
//levelsize/size: 2
//current: 4
//result = 1, 3, 4
