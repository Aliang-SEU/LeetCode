package Data20180423;

import Data20180422.ListNode;

/**
 *
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 You should preserve the original relative order of the nodes in each of the two partitions.
 For example,
 Given1->4->3->2->5->2and x = 3,
 return1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preStart = dummy;
        ListNode pCur = head;
        while(pCur.next != null){
            ListNode next = pCur.next;
            if(next.val < x && pCur.val >= x){
                pCur.next = next.next;
                next.next = preStart.next;
                preStart.next = next;
                preStart = preStart.next;
            }else{
                if(pCur.val < x){
                    preStart = preStart.next;
                }
                pCur = pCur.next;
            }

        }
        return dummy.next;
    }
}
