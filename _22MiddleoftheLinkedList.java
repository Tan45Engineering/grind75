/*Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.*/
public class _22MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        //initialize slow and fast pointers
        ListNode fast = head;
        ListNode slow = head;

        if(head == null){
            return head; //if list is empty, return null
        }

        while(slow != null && fast != null && fast.next != null){
            //move slow pointer by 1 step
            slow = slow.next;

            //move fast pointer by 2 steps
            fast = fast.next.next;
        }

        return slow; //when the fast pointer reaches the end, slow pointer is at the middle
    }
}
//slow: 1, 2, 3, 4
//fast: 1, 3, 5, null

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
