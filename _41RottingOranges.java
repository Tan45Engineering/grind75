import java.util.LinkedList;
import java.util.Queue;

/*You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.



Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4*/
public class _41RottingOranges {
    public int orangesRotting(int[][] grid) {
        //base condition
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        //Traverse the grid, count the fresh oranges, and add the rotten oranges to the queue
        for(int i = 0; i< numRows; i++){
            for(int j = 0; j < numCols; j++){
                //when fresh oranges is encountered
                if(grid[i][j] == 1){
                    freshOranges++;
                }else if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //perform BFS to simulate rotting oranges
        while(!queue.isEmpty() && freshOranges > 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] current = queue.poll();

                for(int[] dir: directions){
                    int newRow = current[0] + dir[0];
                    int newCol = current[1] + dir[1];

                    if(newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && grid[newRow][newCol] == 1){
                        //mark the adjacent fresh oranges as rotten
                        grid[newRow][newCol] = 2;
                        queue.add(new int[]{newRow, newCol});
                        freshOranges--;
                    }
                }
            }

            minutes++;
        }

        return freshOranges == 0 ? minutes: -1;
    }

    public static void main(String args[]){
        _41RottingOranges obj = new _41RottingOranges();
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(obj.orangesRotting(grid));
    }
}

// 2 1 1
// 0 1 1
// 1 0 1

//freshOrangeCount = 6
//keep not of rotten oranges: queue: i = 0, j = 0
