import java.util.Stack;

/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]*/
public class _38MinStack {
    //main stack to store elements
    private Stack<Integer> stack;

    //auxillary stack to keep track of the minimum element at each level
    private Stack<Integer> minStack;

    public _38MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        //push the element onto the main stack
        stack.push(val);

        //update the minimum element in the minStack
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        //pop the element from the main stack
        int popped = stack.pop();

        //if the popped element is the minimum, update the minStack
        if(popped == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        //return the top element of the main stack
        return stack.peek();
    }

    public int getMin() {
        //return the minimum element from the minStack
        return minStack.peek();
    }
}

// stack1
// minStack

//2 1 4 5

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
