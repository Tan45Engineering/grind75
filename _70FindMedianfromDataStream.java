import java.util.Collections;
import java.util.PriorityQueue;

/*The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.


Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]*/
public class _70FindMedianfromDataStream {
    //use maxheap to store elements smaller than current median
    PriorityQueue<Integer> maxheap;

    //use minheap to store elements larger than current median
    PriorityQueue<Integer> minheap;

    public _70FindMedianfromDataStream() {
        //initialize heaps
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        //decide whether to add the number to maxheap or minheap
        if(maxheap.size() == 0 || num <= maxheap.peek()){
            maxheap.add(num);
        }else{
            minheap.add(num);
        }
        //balance the heaps to ensure their size differenece is atmost 1
        balanceheaps();
    }

    //helper method to balance heaps
    private void balanceheaps(){
        //balancing by moving elements
        if(maxheap.size() - minheap.size() > 1){
            //move elements from maxheap to minheap
            minheap.add(maxheap.poll());
        }else if(minheap.size() - maxheap.size() > 1){
            //move elements from minheap to maxheap
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        //determine the current median based on the size of the heaps
        if(maxheap.size() == minheap.size()){
            return (double)(maxheap.peek() + minheap.peek())/2.0;
        }

        return maxheap.size() > minheap.size() ? (double) maxheap.peek() : (double) minheap.peek();
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// 2 3 4 5 6 7 8
// minheap : 6 7 8 9
// maxheap : 2 3 4 5
