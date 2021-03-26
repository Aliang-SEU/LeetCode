package old.Data20180423;

import old.Data20180422.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given1->2->3->4->5->NULLand k =2,
 * return4->5->1->2->3->NULL.
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int n){
        if(head == null)
            return null;
        ListNode fast = head;
        for(int i = 0; i < n; i++)
            fast = fast.next;

        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode start = slow.next;
        slow.next = null;
        fast.next = head;
        return start;
    }
}
