package old.Data20180508;

import old.Data20180422.ListNode;

public class RemoveDuplicatesfromSortedArrayII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode node = head;

        while(node != null){
            ListNode next = node.next;
            if(next == null || node.val != next.val){
                pre = node;
                node = next;
            }else {
                while (next != null && next.val == node.val) {
                    next = next.next;
                }
                pre.next = next;
                node = next;
            }
        }
        return dummy.next;
    }
}
