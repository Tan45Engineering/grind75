import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.*/
public class _63MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        //base case
        if(n == 1){
            result.add(0); //there is only one node, so it's the root
            return result;
        }

        //adjacency list to represent the graph
        List<Set<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new HashSet<>());
        }

        //array to store degree of each node
        int[] degree = new int[n];

        //build adjList and degree array
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        //set to store current leaves
        Set<Integer> leaves = new HashSet<>();

        //add initial leaves to the set
        for(int i = 0; i < n; i++){
            if(degree[i] == 1){
                leaves.add(i);
            }
        }

        //iterate until there are 1 or 2 nodes left
        while(n > 2){
            Set<Integer> newLeaves = new HashSet<>();

            //remove the current leaves and update the degree
            for(int leaf: leaves){
                n--; //decrement the total number of nodes
                degree[leaf]--;
                for(int neighbour: adjList.get(leaf)){
                    degree[neighbour]--;
                    if(degree[neighbour] == 1){
                        newLeaves.add(neighbour); //add the new leaves
                    }
                }
            }

            leaves = newLeaves; //update the set of leaves for the next iteration
        }

        result.addAll(leaves); //remaining leaves are the roots (core) of MHTs
        return result;
    }

    public static void main(String args[]){
        _63MinimumHeightTrees obj = new _63MinimumHeightTrees();
        int n = 4;
        int[][] edges = {
                {1, 0},
                {1, 2},
                {1, 3}
        };
        System.out.println(obj.findMinHeightTrees(n, edges));
    }
}
