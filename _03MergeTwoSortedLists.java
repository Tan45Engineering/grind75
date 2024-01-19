/*
* You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
* Example 2:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]*/


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Create a new ListNode to store the merged list
        ListNode list = new ListNode();
        ListNode temp = new ListNode();

        //intialize list with a temporary node
        list = temp;

        //iterate while both list1 and list2 are not empty
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                //if the value in the list1 is smaller, add it to the merged list
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }else{
                //if the value in list2 is smaller(or equal), add it to the the merged list
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }

        //if either list1 or list2 is not empty, add it to the merged list
        temp.next = (list1 != null) ? list1:list2;

        return list.next;
    }

}

/**
 * Definition for singly-linked list.*/
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

// 1-2-4-6-7-8
//1-3-4

//1-1-2-3-4-4-6-7-8