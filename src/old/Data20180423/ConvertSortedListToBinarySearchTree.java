package old.Data20180423;

import old.Data20180422.ListNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args){
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);

        TreeNode node = new ConvertSortedListToBinarySearchTree().sortedListToBST(root);
        System.out.println();

    }
    public TreeNode sortedListToBST(ListNode head){
        return toBST(head, null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        if(head == tail)
            return null;
        ListNode mid = findMid(head, tail);
        TreeNode root = new TreeNode(mid.val);
        ListNode right = mid.next;
        root.left = toBST(head, mid);
        root.right = toBST(right, tail);
        return root;
    }

    /**
     * 返回链表的中间点指针
     * @param head
     * @return
     */
    public ListNode findMid(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
