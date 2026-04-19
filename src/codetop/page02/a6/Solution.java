package codetop.page02.a6;

import hot100.linklisted.pojo.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @create 2026/4/18 09:24
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) return;
        ListNode fast = head, slow = head;
        int count = 0;
        while (fast != null) {
            fast = fast.next;
            count++;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            count++;
            slow = slow.next;
        }
        if (count % 2 == 1) slow = slow.next;
        Deque<ListNode> stack = new LinkedList<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        ListNode dummyNode = new ListNode();
        ListNode p = dummyNode;
        while (!stack.isEmpty()) {
            p.next = head;
            head = head.next;
            p = p.next;
            p.next = stack.pop();
            p = p.next;
        }
        if (count % 2 == 1) {
            p.next = head;
            p = p.next;
        }
        p.next = null;
    }
}
