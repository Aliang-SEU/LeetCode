package Data20180423;

import Data20180422.ListNode;

import java.util.LinkedList;

/**
 * reorder list
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 *  reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 *  Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class ReorderList {
    public static void main(String[] args){
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        new ReorderList().reorderList(root);
        ListNode node = root;
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 快慢指针找到中间节点，将后面的链表反转(前插法),合并列表
     *
     * @param head
     */
    public void reorderList(ListNode head){
        if(head == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        /**
         * 利用前插法反转链表(链表不会断开)
         */
        ListNode pre = slow.next;
        if(pre != null && pre.next != null){
            ListNode next = pre.next;
            while(next != null){
                pre.next = next.next;
                next.next = slow.next;
                slow.next = next;
                next = pre.next;
            }
        }
        ListNode p = head;
        ListNode q = slow.next;
        while(p != null && q!= null){
            slow.next =q.next;
            q.next = p.next;
            p.next = q;
            q = slow.next;
            p = p.next.next;
        }
    }
    public void reorderList1(ListNode head){
        /**
         * 使用队列实现
         */
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode node = head;
        while(node != null){
            queue.offer(node);
            node = node.next;
        }
        /**
         * 依次首尾弹出节点并拼接
         */
        ListNode dummy = new ListNode(0);
        ListNode pCur = dummy;
        while(!queue.isEmpty()){
            ListNode pre = queue.poll();
            pCur.next = pre;
            pCur = pCur.next;
            if(!queue.isEmpty()) {
                ListNode post = queue.pollLast();
                pCur.next = post;
                pCur = pCur.next;
            }
        }
        pCur.next = null;
    }

}
