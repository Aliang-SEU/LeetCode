package old.Data20180423;

import old.Data20180422.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode pCur = dummy;
        ListNode p = l1;
        ListNode q = l2;
        while(p != null || q != null){
            if(p == null) {
                pCur.next = q;
                q = q.next;
                pCur = pCur.next;
                continue;
            }
            if(q == null){
                pCur.next = p;
                p = p.next;
                pCur = pCur.next;
                continue;
            }
            if(p.val < q.val){
                pCur.next = p;
                p = p.next;
                pCur = pCur.next;
            }else{
                pCur.next = q;
                q = q.next;
                pCur = pCur.next;
            }
        }
        return dummy.next;
    }
}
