package old.Data20180423;

import old.Data20180422.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given1->2->3->4, you should return the list as2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preStart = dummy;
        ListNode start = head;

        while(start != null && start.next != null){
            ListNode next = start.next;
            start.next = next.next;
            next.next = preStart.next;
            preStart.next = next;
            preStart = start;
            start = start.next;
        }
        return dummy.next;
    }

}
