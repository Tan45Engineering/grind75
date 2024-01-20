import java.util.Arrays;

/*An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

*/
public class _09FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];//get the old color from the starting pixel

        if(oldColor == color){
            //No need to perform flood fill, return the original image
            return image;
        }

        //call the dfs function to start the flood fill
        dfs(image, sr, sc, color, oldColor);

        //return the modified image
        return image;
    }

    //Depth-First Search (DFS) function
    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor){
        //base cases
        //1. if the current pixel is out of bounds, return
        //2. if the current pixel has a different color, return
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor){
            return;
        }

        //change the color of the current pixel
        image[sr][sc] = newColor;

        //recursively call dfs for all the neighboring pixels
        dfs(image, sr+1, sc, newColor, oldColor); // Down
        dfs(image, sr-1, sc, newColor, oldColor); // Up
        dfs(image, sr, sc+1, newColor, oldColor); // Right
        dfs(image, sr, sc-1, newColor, oldColor); // Left
    }

    public static void main(String args[]){
        _09FloodFill obj = new _09FloodFill();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] ans = obj.floodFill(image, sr, sc, color);
        System.out.println(Arrays.deepToString(ans));
    }
}
