import java.util.Arrays;

/*Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.



Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]*/
public class _27_01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int maxLength = mat.length + mat[0].length;
        int top = 0;
        int left = 0;
        int right = 0;
        int bottom = 0;

        //iterate from top-left to bottom-right
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    continue;
                }else{
                    left = maxLength;
                    top = maxLength;

                    //update the left distance if possible
                    if(i > 0){
                        left = mat[i-1][j];
                    }

                    //update top distance if possible
                    if(j > 0){
                        top = mat[i][j-1];
                    }
                    //set the current cell distance to the minimum of left and top distances + 1
                    mat[i][j] = Math.min(left, top) + 1;
                }
            }
        }

        //iterate from bottom-right to top-left
        for(int i = mat.length-1; i>= 0 ; i--){
            for(int j = mat[0].length-1; j>= 0; j--){
                if(mat[i][j] == 0){
                    continue;
                }else{
                    right = maxLength;
                    bottom = maxLength;

                    //update bottom distance if possible
                    if(i < mat.length -1){
                        bottom = mat[i+1][j];
                    }

                    //update right distance if possible
                    if(j < mat[0].length-1){
                        right = mat[i][j+1];
                    }

                    //set the current cell distance to the minimum of bottom and right +1
                    mat[i][j] = Math.min(Math.min(right, bottom) + 1, mat[i][j]);
                }
            }
        }

        return mat;
    }

    public static void main(String args[]){
        _27_01Matrix obj = new _27_01Matrix();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] result = obj.updateMatrix(mat);
        System.out.println(Arrays.deepToString(result));
    }
}
