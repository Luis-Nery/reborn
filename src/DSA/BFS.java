package DSA;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public void bfs(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (queue.peek().left != null) {
                queue.offer(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.offer(queue.peek().right);
            }
            if (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
        }
    }
}
