package old.Data20180411;

import old.DataType.RandomListNode;

public class CopyListWithRandomPointer {
	  public RandomListNode copyRandomList(RandomListNode head) {
          if(head == null)
              return null;
          RandomListNode curNode = head;
          while(curNode != null){
              RandomListNode node = new RandomListNode(curNode.label);
              node.next = curNode.next;
              curNode.next = node;
              curNode = node.next;
          }
          curNode = head;
          while(curNode != null){
              if(curNode.random != null)
                  curNode.next.random = curNode.random.next;
              curNode = curNode.next.next;
          }
          RandomListNode curCopyHead = head.next;
          RandomListNode curCopyNode = head.next;
          curNode = head;
          while(curNode != null){
              curNode.next = curCopyNode.next;
              if(curCopyNode.next != null)
                  curCopyNode.next = curCopyNode.next.next;
              curNode = curNode.next;
              curCopyNode = curCopyNode.next;
          }
          return curCopyHead;
  }
}
