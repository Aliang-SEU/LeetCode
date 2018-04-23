package Data20180422;

/**
 * SortList
 */
public class SortList {

    public static void main(String[] args){
        /*
        int[] a = new int[]{6,5,4,2,7,9,8,4,1};
        System.out.println(Arrays.toString(new SortList().mergeSort(new int[]{56,43,4,3,65,0,2,32,353})));
        new SortList().mergeSort1(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        */
        ListNode root = new ListNode(3);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(44);
        root.next.next.next.next = new ListNode(5);

        ListNode node = new SortList().sortList(root);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }

    /**
     * 自顶向下的归并排序
     * @param a
     * @return
     */
    public void mergeSort1(int[] a, int start, int end){
        if(start >= end)
            return;

        int mid = (end - start) / 2 + start;
        mergeSort1(a, start, mid);
        mergeSort1(a, mid + 1, end);
        int[] tempArr = new int[end - start + 1];
        int i = start, j = mid + 1, idx = 0;
        while(idx < tempArr.length){
            if(i > mid)
                tempArr[idx++] = a[j++];
            else if(j > end)
                tempArr[idx++] = a[i++];
            else if(a[i] > a[j])
                tempArr[idx++] = a[j++];
            else if(a[i] <= a[j])
                tempArr[idx++] = a[i++];
        }
        System.arraycopy(tempArr,0, a, start, tempArr.length);
    }
    /**
     * 自底向上的归并排序
     * @param a
     * @return
     */
    public int[] mergeSort(int[] a){
        //每次归并数组的大小
        for(int i = 1; i < a.length; i *= 2){
            //每次归并的数组范围
            for(int j = 0; j < a.length; j += 2 * i){
                merge(a, j, j + i - 1, Math.min(j + i + i - 1, a.length - 1));
            }
        }
        return a;
    }

    public void merge(int[] a, int start, int mid, int end){
        if(start == end)
            return;

        int[] tempArr = new int[end - start + 1];
        int i = start, j =mid + 1, idx = 0;
        while(idx < tempArr.length){
            if(i > mid)
                tempArr[idx++] = a[j++];
            else if(j > end)
                tempArr[idx++] = a[i++];
            else if(a[i] > a[j])
                tempArr[idx++] = a[j++];
            else if(a[i] <= a[j])
                tempArr[idx++] = a[i++];
        }
        System.arraycopy(tempArr,0, a, start, tempArr.length);
    }
    /**
     * 自顶向下的归并排序(单链表)
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode mid = findMin(head);
        ListNode rStart = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rStart);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode pCur = dummy;
        while(left != null && right != null){
            if(left.val <= right.val){
                pCur.next = left;
                left = left.next;
                pCur = pCur.next;
            }else {
                pCur.next = right;
                right = right.next;
                pCur = pCur.next;
            }
        }
        while(left != null){
            pCur.next = left;
            left = left.next;
            pCur = pCur.next;
        }
        while(right != null){
            pCur.next = right;
            right = right.next;
            pCur = pCur.next;
        }
        return dummy.next;
    }
    public ListNode findMin(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
