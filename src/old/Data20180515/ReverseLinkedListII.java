package old.Data20180515;

import old.Data20180422.ListNode;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);

        ListNode res = new ReverseLinkedListII().reverseBetween(head, 2, 4);
        System.out.println();
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m >= n)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pPre = dummy;
        ListNode pCur = head;

        int count = 1;
        while(count < m && pPre != null) {
            pPre = pPre.next;
            count++;
        }
        if(pCur == null)
            return head;
        pCur = pPre.next;
        while(count < n && pCur != null) {
            ListNode next = pCur.next;
            pCur.next = next.next;
            next.next = pPre.next;
            pPre.next = next;
            count++;
        }

        return dummy.next;
    }
}
