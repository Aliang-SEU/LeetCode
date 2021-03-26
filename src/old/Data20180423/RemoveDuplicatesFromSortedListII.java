package old.Data20180423;

import old.Data20180422.ListNode;

/**
 *
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 For example,
 Given1->2->3->3->4->4->5, return1->2->5.
 Given1->1->1->2->3, return2->3.
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preStart = dummy;
        ListNode start = head;
        while(start != null){
            ListNode next = start.next;
            if(next == null)
                return dummy.next;
            if(start.val != next.val){
                start = start.next;
                preStart = preStart.next;
            }
            else {
                while (next != null && start.val == next.val) {
                    next = next.next;
                }
                preStart.next = next;
                start = next;
            }
        }
        return dummy.next;
    }
}
