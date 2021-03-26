package old.Data20180423;

import old.Data20180422.ListNode;

import java.util.ArrayList;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
    public static void main(String[] args){
        ArrayList<ListNode> list = new ArrayList<>();

        ListNode a = null;
        ListNode b = null;
        list.add(a);
        list.add(b);
        new MergeKSortedLists().mergeKLists(list);

    }
    public ListNode mergeKLists(ArrayList<ListNode> lists){
        if(lists.size() == 0)
            return null;
        while(lists.size() > 1){
            ListNode dummy = new ListNode(0);
            ListNode pCur = dummy;
            ListNode l1 = lists.get(lists.size() - 2);
            ListNode l2 = lists.get(lists.size() - 1);
            while(l1 != null || l2 != null){
                if(l1 == null){
                    pCur.next = l2;
                    pCur = pCur.next;
                    l2 = l2.next;
                    continue;
                }
                if(l2 == null){
                    pCur.next = l1;
                    pCur = pCur.next;
                    l1 = l1.next;
                    continue;
                }
                if(l1.val < l2.val){
                    pCur.next = l1;
                    l1 = l1.next;
                    pCur = pCur.next;
                }else{
                    pCur.next = l2;
                    l2 = l2.next;
                    pCur = pCur.next;
                }
            }
            lists.remove(lists.size() - 1);
            lists.remove(lists.size() - 1);
            lists.add(dummy.next);
        }
        return lists.get(0);
    }

}
