import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
*/
public class _32CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        //use a map to keep track of nodes in the original graph and thier correspoinding clones
        Map<Node, Node> cloneMap = new HashMap<>();
        return cloneNode(node, cloneMap);
    }

    private Node cloneNode(Node original, Map<Node, Node> cloneMap){
        //check if the node is already cloned
        if(cloneMap.containsKey(original)){
            return cloneMap.get(original);
        }

        //clone the current node
        Node clone = new Node(original.val);
        cloneMap.put(original, clone);

        //recursively clone the neighbours
        for(Node neighbor: original.neighbors){
            clone.neighbors.add(cloneNode(neighbor, cloneMap));
        }

        return clone;
    }
}

/*
// Definition for a Node.*/
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


//clonemap: 1 ->2 1->4, 2->1 2->3, 3->2 3->4, 4->1 4->3,
