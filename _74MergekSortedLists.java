/*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6*/
public class _74MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        //base case
        if(lists == null || lists.length == 0){
            return null;
        }

        int interval = 1;

        //iterate through the lists array
        while(interval < lists.length){
            for(int i = 0; i+interval < lists.length; i += interval*2){
                lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    //merge two lists
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode temp = new ListNode(0);
        ListNode current = temp;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        //if l1 is still not empty
        if(l1 != null){
            current.next = l1;
        }else{
            current.next = l2;
        }

        return temp.next;
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

//[1, 4, 5, 6, 7, 8, 9], [1, 3, 4]
//=[1, 1, 3, 4, 5]
