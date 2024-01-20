import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
*/
public class _31BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        //check if the root is null
        if(root == null){
            return result;
        }

        //create a queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //perform level order traversal
        while(!queue.isEmpty()){
            int levelSize = queue.size();// 2
            List<Integer> levelNodes = new ArrayList<>();

            //process nodes at the current level
            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                levelNodes.add(node.val);

                //enqueue left and right children if they exist
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            //add the nodes at the current level to the result
            result.add(levelNodes);
        }

        return result;
    }
}

//queue:
//levelNodes: [15, 7]
//resutl: [[3], [9, 20], [15, 7]]

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