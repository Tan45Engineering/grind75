/*Given the head of a singly linked list, reverse the list, and return the reversed list.*/
public class _18ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //initialize the pointers; prev, curr, next
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = head;

        while(currNode != null){
            //store the next node in nextNode as we will modify the current node's next poiter
            nextNode = currNode.next;

            //reverse the current node by making its next pointer point to the previoud node
            currNode.next = prevNode;

            //move the prev and current pointers one step forward for the next iteration
            prevNode = currNode;
            currNode = nextNode;
        }

        //once the loop finishes, the prev pointer will point to the new head of the reversed linked list
        return prevNode;

    }
}

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
