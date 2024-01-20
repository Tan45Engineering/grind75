import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.*/
public class _34CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build the adjacency list represenatation of the graph
        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);

        //keep track of the visited nodes during DFS
        boolean[] visited = new boolean[numCourses];

        //perform DFS on each node
        for(int course = 0; course< numCourses; course++){
            if(!visited[course] && hasCycle(graph, visited, new boolean[numCourses], course)){
                //cycle is found, return false
                return false;
            }
        }

        //no cycle found, return true
        return true;
    }

    //helper method to build the adjacency list representation of the graph
    private Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites){
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] prerequisite: prerequisites){
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            //add the prerequisite course to the adjacency list of the course
            graph.computeIfAbsent(course, k -> new ArrayList<>()).add(prerequisiteCourse);
        }

        return graph;
    }

    //helper method to check for a cycle in the graph using dfs
    private boolean hasCycle(Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] recursionStack, int course){
        visited[course] = true;
        recursionStack[course] = true;

        //visit neighbours
        if(graph.containsKey(course)){
            for(int neighbour: graph.get(course)){
                if(!visited[neighbour]){
                    if(hasCycle(graph, visited, recursionStack, neighbour)){
                        return true;
                    }
                }else if(recursionStack[neighbour]){
                    //if the neighbour is already in the recursion stack, cycle is found
                    return true;
                }
            }
        }

        //backtrack
        recursionStack[course] = false;

        return false;
    }

    public static void main(String args[]){
        _34CourseSchedule obj = new _34CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(obj.canFinish(numCourses, prerequisites));
    }
}

//build graph
//dfs search
//if cycle exists
