package Data20180424;

import Data20180422.ListNode;

public class SwapNoedsInPairs {

    public ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        ListNode node = head;
        while(node != null && node.next != null){
            ListNode next = node.next;
            node.next = next.next;
            next.next = pre.next;
            pre.next = next;
            pre = node;
            node = node.next;
        }
        return dummy.next;
    }

}
