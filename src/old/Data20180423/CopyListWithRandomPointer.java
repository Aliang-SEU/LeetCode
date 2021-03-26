package old.Data20180423;

public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head){
        if (head == null)
            return null;

        RandomListNode pCur = head;
        while (pCur != null) {
            RandomListNode node = new RandomListNode(pCur.val);
            node.next = pCur.next;
            pCur.next = node;
            pCur = pCur.next.next;
        }
        RandomListNode pNode = head;
        pCur = head;
        while (pCur != null) {
            pNode = pCur.next;
            if(pCur.random != null)
                pNode.random = pCur.random.next;
            pCur = pCur.next.next;
        }
        //断开链表
        RandomListNode dummy = new RandomListNode(0);
        pNode = dummy;
        pCur = head;

        while(pCur != null){
            pNode.next = pCur.next;
            pCur.next = pCur.next.next;
            pNode = pNode.next;
            pCur = pCur.next;
        }
        return dummy.next;
    }

}
