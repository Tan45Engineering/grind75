import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.*/
public class _68SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    //helper method to be called recursively
    private void serializeHelper(TreeNode node, StringBuilder sb){
        //base case: if the node is null, return null
        if(node == null){
            sb.append("null").append(",");
        }else{
            sb.append(node.val).append(",");
            serializeHelper(node.left, sb); //left child
            serializeHelper(node.right, sb); // right child
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    //helper method to be called recursively
    private TreeNode deserializeHelper(Queue<String> nodes){
        String val = nodes.poll();
        //base case: if null, return null
        if(val.equals("null")){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = deserializeHelper(nodes);
            node.right = deserializeHelper(nodes);
            return node;
        }
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

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
