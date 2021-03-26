package old.Data20180422;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEach {

    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        LinkedList<TreeLinkNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode pre = queue.poll();
            if (pre.left != null)
                queue.offer(pre.left);
            if (pre.right != null)
                queue.offer(pre.right);
            while (--size > 0) {
                TreeLinkNode post = queue.poll();
                pre.next = post;
                if (post.left != null)
                    queue.offer(post.left);
                if (post.right != null)
                    queue.offer(post.right);
                pre = post;
            }
            pre.next = null;
        }
    }
}
