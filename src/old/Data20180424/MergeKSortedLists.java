package old.Data20180424;

import old.Data20180422.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    /**
     * 使用优先队列实现
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(0), dummy = dummyHead;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) if (list != null) minHeap.offer(list);

        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            dummy = dummy.next = min;
            if (min.next != null) minHeap.offer(min.next);
        }

        return dummyHead.next;
    }
}
