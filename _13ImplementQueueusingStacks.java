import java.util.Stack;

/*Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.


Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]*/
public class _13ImplementQueueusingStacks {
    public Stack<Integer> stack1, stack2;
    // 10, 20, 30, 40
    public _13ImplementQueueusingStacks() {
        stack1 = new Stack<>();//initialize main stack
        stack2 = new Stack<>();//initialize secondary stack
    }

    public void push(int x) {
        //push the element to the back of the queue, which is top of stack1
        stack1.push(x);
    }

    public int pop() {
        //to remove an element from the front of the queue, transfer all elements from stack1 to stack2
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int result = stack2.pop();//the element to be removed is now at the top of stack2

        //transfer the remaining elements back to stack1 to maintain the order
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return result;
    }

    public int peek() {
        //to peek at the element at the front of the queue, transfer all the elements from stack1 to stack2
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.peek(); //the element at the front is not at the top of stack2

        //transfer the ramaining elements back to stack1, to maintain the order
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public boolean empty() {
        return stack1.isEmpty(); // the queue is empty if stack1 is empty.
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
