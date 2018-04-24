package Data20180424;

import Data20180422.ListNode;


/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodeInKGroup {

    public ListNode reverseKGroup(ListNode head, int k){
        int len = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            len++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        node = head;
        for(int i = 0; i < len / k; i++){
            for(int j = 1; j < k; j++){
                ListNode next = node.next;
                node.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = node;
            node = node.next;
        }
        return dummy.next;
    }
}
