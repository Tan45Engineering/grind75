import java.util.ArrayList;
import java.util.List;

/*Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]*/
public class _53SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        //check for empty matrix
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }

        int m = matrix.length; //Number of rows
        int n = matrix[0].length; //Number of columns

        int top = 0; //top boundary
        int bottom = m-1; // bottom boundary
        int left = 0; //left boundary
        int right = n-1; // right boundary

        while(top <= bottom && left <= right){
            //Traverse the top
            for(int i = left; i <= right; i++){
                result.add(matrix[top][i]);
            }
            top++;

            //Traverse the right
            for(int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;

            //check if there is a remaining row (to avoid duplicates)
            if(top <= bottom){
                //Traverse the bottom row
                for(int i = right; i >= left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //check if there is a remaining column (to avoid duplicates)
            if(left <= right){
                //Traverse the left
                for(int i = bottom; i>= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String args[]){
        _53SpiralMatrix obj = new _53SpiralMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(obj.spiralOrder(matrix));
    }
}
