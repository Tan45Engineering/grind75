/*Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"*/
public class _61WordSearch {
    public boolean exist(char[][] board, String word) {
        //concert the string to character array for easy access
        char[] wordArray = word.toCharArray();

        //iterate through each cell in the grid
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                //start the backtracking from the current cell
                if(backtrack(board, i, j, wordArray, 0)){
                    return true; //word found
                }
            }
        }

        return false; //word not found
    }

    //backtracking method
    private boolean backtrack(char[][] board, int i, int j, char[] word, int index){
        //check if we have found the word
        if(index == word.length){
            return true;
        }

        //check if the current cell is out of bounds, or the character doesn't match
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[index]){
            return false;
        }

        //temporarily mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = '*';

        //explore adjacent cells in all four directions
        boolean result = (backtrack(board, i+1, j, word, index+1) ||
                backtrack(board, i-1, j, word, index+1) ||
                backtrack(board, i, j+1, word, index+1) ||
                backtrack(board, i, j-1, word, index+1));

        //restore the original value of the current cell
        board[i][j] = temp;

        return result;
    }

    public static void main(String args[]){
        _61WordSearch obj = new _61WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";
        System.out.println(obj.exist(board, word));
    }
}
