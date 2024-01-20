import java.util.Arrays;

/*Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]*/
public class _28KClosestPointstoOrigin02 {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]);
        return Arrays.copyOfRange(points, 0, k);
    }

    public static void main(String args[]){
        _28KClosestPointstoOrigin01 obj = new _28KClosestPointstoOrigin01();
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] result = obj.kClosest(points, k);
        System.out.println(Arrays.deepToString(result));
    }
}

// (a*a + a*a) - b*b - b*b;
