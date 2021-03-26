package old.Data20180423;

import old.Data20180422.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list:1->2->3->4->5
 * For k = 2, you should return:2->1->4->3->5
 * For k = 3, you should return:3->2->1->4->5
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode node = head;
        while(node != null){
            len++;
            node = node.next;
        }
        ListNode preStart = dummy;
        ListNode start = head;
        len = len / k;
        for(int i = 0; i < len; i++){
            for(int j = 1; j < k; j++){
                ListNode next = start.next;
                start.next = next.next;
                next.next = preStart.next;
                preStart.next = next;
            }
            preStart = start;
            start = start.next;
        }
        return dummy.next;
    }

}
