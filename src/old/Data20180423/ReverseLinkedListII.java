package old.Data20180423;

import old.Data20180422.ListNode;

/**
 *
 Reverse a linked list from position m to n. Do it in-place and in one-pass.
 For example:
 Given1->2->3->4->5->NULL, m = 2 and n = 4,
 return1->4->3->2->5->NULL.
 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.

 */
public class ReverseLinkedListII {

    /**
     *  使用前插法来实现，记录移动的数量
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = head;
        ListNode preStrat = dummy;

        for(int i = 1; i < m; i++){
            start = start.next;
            preStrat = preStrat.next;
        }

        for(int i = 0; i < n - m; i++){
            ListNode next = start.next;
            start.next = next.next;
            next.next = preStrat.next;
            preStrat.next = next;
        }
        return dummy.next;
    }

}
