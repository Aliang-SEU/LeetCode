package DefaultPackage;
public class sortList {
	class ListNode{
		int val;
		ListNode next;
		
		ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}
    public static void main(String[] args) {
    	sortList list = new sortList();
    	ListNode head = list.new ListNode(2);
    	head.next = list.new ListNode(3);
    	head.next.next = list.new ListNode(1);
    	head.next.next.next = list.new ListNode(4);
      	head.next.next.next.next = list.new ListNode(5);
      	head.next.next.next.next.next = list.new ListNode(7);
      	list.sortList1(head);
    	
    }
    public ListNode sortList1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode middle = head, l2 = head;
        while(l2.next != null && l2.next.next != null){
            l2 = l2.next.next;
            middle = middle.next;
        }
        ListNode right = middle.next;
        middle.next = null;
        return mergeSortedList(sortList1(head), sortList1(right));
    }
    public ListNode mergeSortedList(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null){
            p.next = l1;
        }
        else{
            p.next = l2;
        }
        return head.next;
    }
}
