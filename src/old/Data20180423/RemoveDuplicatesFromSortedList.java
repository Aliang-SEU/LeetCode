package old.Data20180423;

import old.Data20180422.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given1->1->2, return1->2.
 * Given1->1->2->3->3, return1->2->3.
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head){
        if(head == null)
            return null;
        ListNode dummy =  new ListNode(0);
        dummy.next = head;
        ListNode start = head;

        while(start.next != null){
            ListNode next = start.next;
            if(next.val == start.val) {
                start.next = next.next;
                continue;
            }else
                start = start.next;
        }
        return dummy.next;
    }
}
