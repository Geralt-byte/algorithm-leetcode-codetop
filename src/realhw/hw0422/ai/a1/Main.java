package realhw.hw0422.ai.a1;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 小红正在分析一个用于智能体推理的决策树。树上的每个节点都记录了一个整数分值，表示模型在这一层做出某个选择时带来的偏移量。
 * 如果一条路径同时满足下面三个条件，小红就把它称为一条平衡路径：
 * 1. 路径可以从树中的任意节点开始；
 * 2. 从起点出发后，每一步都只能走向当前节点的左子节点或右子节点，也就是说整条路径必须始终向下延伸，不能回到父节点，也不能分叉；
 * 3. 路径上所有节点的分值之和恰好为 0，并且这条路径包含的节点个数至少为 2。
 * 现在给定这棵二叉树的层序遍历结果，请你帮助小红统计这棵树中一共有多少条平衡路径。
 * @create 2026/5/5 11:31
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strings = sc.nextLine().split(" ");
        TreeNode root = new TreeNode();
        buildTree(strings, root);
        System.out.println(countZeroPaths(root));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static void buildTree(String[] strings, TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        int index = 0;
        root.val = Integer.parseInt(strings[index++]);
        deque.offer(root);
        while (!deque.isEmpty() && index < strings.length) {
            TreeNode node = deque.poll();
            String left = strings[index++];
            if (!left.equals("None")) {
                node.left = new TreeNode(Integer.parseInt(left));
                deque.offer(node.left);
            }
            if (index < strings.length) {
                String right = strings[index++];
                if (!right.equals("None")) {
                    node.right = new TreeNode(Integer.parseInt(right));
                    deque.offer(node.right);
                }
            }
        }
    }

    // 使用迭代 DFS 统计所有和为0且长度>=2的向下路径数量
    private static long countZeroPaths(TreeNode root) {
        // 用于记录当前路径上各父节点前缀和出现的次数
        Map<Long, Integer> cnt = new HashMap<>();
        long ans = 0;
        // 栈中元素: [node, parentPrefix, visitedFlag]
        Deque<Object[]> stack = new ArrayDeque<>();
        stack.push(new Object[]{root, 0L, false});
        while (!stack.isEmpty()) {
            Object[] top = stack.pop();
            TreeNode node = (TreeNode) top[0];
            long parentPre = (Long) top[1];
            boolean visited = (Boolean) top[2];
            if (node == null) continue;
            if (!visited) {
                long curPre = parentPre + node.val;   // 当前节点的前缀和
                // 查询以当前节点为终点的合法路径数
                ans += cnt.getOrDefault(curPre, 0);
                // 将父节点的前缀和计入计数，供后代节点使用
                cnt.put(parentPre, cnt.getOrDefault(parentPre, 0) + 1);
                // 标记回溯状态
                stack.push(new Object[]{node, parentPre, true});
                // 先压右孩子再压左孩子，保证左孩子先被处理（栈后进先出）
                if (node.right != null) stack.push(new Object[]{node.right, curPre, false});
                if (node.left != null) stack.push(new Object[]{node.left, curPre, false});
            } else {
                // 回溯，恢复计数
                int count = cnt.get(parentPre);
                if (count == 1) cnt.remove(parentPre);
                else cnt.put(parentPre, count - 1);
            }
        }
        return ans;
    }
}
