package old.DefaultPackage;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
  }
public class Solution {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		 l1.next =new ListNode(9);
		ListNode l2 = new ListNode(1);
		ListNode result = new Solution().addTwoNumbers(l1, l2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode result = head;
        int carry_in = 0;
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val + carry_in;
            carry_in = (sum >= 10)?1:0;
            l1 = l1.next;
            l2 = l2.next;
            result.next = new ListNode(sum % 10);
            result = result.next;

        }
        if(l1 == null && l2 != null){
            while(carry_in !=0 && l2 !=null){
            int sum = l2.val + carry_in;
            carry_in = (sum >= 10)?1:0;
            l2 = l2.next;
            result.next = new ListNode(sum % 10);
            result = result.next;
            }
            result.next = l2;
        }
        else if(l2 == null && l1!=null){
            while(carry_in !=0 && l1 != null){
            int sum = l1.val + carry_in;
            carry_in = (sum >= 10)?1:0;
            l1 = l1.next;
            result.next = new ListNode(sum % 10);
            result = result.next;
            }
            result.next = l1;
    	}
        if(carry_in != 0){
            result.next = new ListNode(carry_in);
            result = result.next;
            }
    return head.next;
    }
}