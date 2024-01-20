import java.util.Arrays;
import java.util.PriorityQueue;

/*Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].*/
public class _28KClosestPointstoOrigin01 {
    public int[][] kClosest(int[][] points, int k) {
        //create a priorityQueue based on the distance from the origin
        //We use a lambda expression to define the comparator for the max heap
        //the lambda expression compares points based on their squared distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1]));

        //iterate through each point in the given array
        for(int[] point: points){
            //add the point to the priority queue
            pq.offer(point);

            //if the size of the priority queue exceeds k, remove the fartherst point(element)
            if(pq.size() > k){
                pq.poll();
            }
        }

        //create a result array
        int[][] result = new int[k][2];

        //popluate the result array
        while(k > 0){
            result[--k] = pq.poll();
        }

        return result;
    }

    public static void main(String args[]){
        _28KClosestPointstoOrigin01 obj = new _28KClosestPointstoOrigin01();
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] result = obj.kClosest(points, k);
        System.out.println(Arrays.deepToString(result));
    }
}

//we need a list, to store elements with closest distance
//keep only k elements
//return in form of array

// 3, 5, 6, 11, 7, 9, 34, 2
