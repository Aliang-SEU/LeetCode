package old.Data20180423;

import old.Data20180422.ListNode;

/**
 * Given a linked list, remove the n th node from the end of list and return its head.
 * For example,
 *    Given linked list: 1->2->3->4->5, and n = 2.
 *
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n){
        if(head.next == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        ListNode pre = dummy;
        while(fast != null){
            pre = pre.next;
            fast = fast.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

}
