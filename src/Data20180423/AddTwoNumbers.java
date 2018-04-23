package Data20180423;

import Data20180422.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        int temp = 0;
        while(l1 != null || l2 != null || temp != 0){
            if(l1 != null){
                temp += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                temp += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(temp % 10);
            node = node.next;
            temp /= 10;
        }
        return dummy.next;
    }
}
