/*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1*/
public class _40NumberofIslands {
    public int numIslands(char[][] grid) {
        //base condition
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int isLandCount = 0;

        //traerse the matrix
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                //check of land
                if(grid[i][j] == '1'){
                    //found the start of the island, increment land counter and perform DFS to mark the entire island
                    isLandCount++;
                    dfs(grid, i, j);
                }
            }
        }

        return isLandCount;
    }

    private void dfs(char[][] grid, int row, int col){
        int numRows = grid.length;
        int numCols = grid[0].length;

        //base cases for recursion
        if(row < 0 || col < 0 || row >= numRows || col >= numCols || grid[row][col] == '0'){
            return;
        }

        //mark the current cell as visited
        grid[row][col] = '0';

        //explore neighbouring cells in all the four directions
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }

    public static void main(String args[]){
        _40NumberofIslands obj = new _40NumberofIslands();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(obj.numIslands(grid));
    }
}

// ["0","0","0","0","0"],
// ["0","0","0","0","0"],
// ["0","0","0","0","0"],
// ["0","0","0","0","0"]

//noOfIsland = 3
