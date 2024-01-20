/*Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.



Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).*/
public class _12LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        //intialize two pointers, slow and fast, both initially pointing at the head of list
        ListNode slow = head;
        ListNode fast = head;

        //Traverse the list with two pointers: slow moves one step at a time, and fast moves two steps at a time
        while( slow != null && fast != null && fast.next != null){
            slow = slow.next; //move slow pointer by one step
            fast = fast.next.next; //move fast pointer by two steps

            //if there is a cycle, the slow and fast pointers will eventually meet at the same node
            if(slow == fast){
                return true; //cycle detected
            }
        }

        //if the fast pointer reaches the end of the list (or becomes null), there is no cycle.
        return false; //no cycle detected
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


//slow: 3 -> 2 -> 0 -> -4
//fast: 3 -> 0 -> 2 -> -4
