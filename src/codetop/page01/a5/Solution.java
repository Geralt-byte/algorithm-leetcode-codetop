package codetop.page01.a5;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @create 2026/4/11 20:28
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode();
        ListNode pre = head, p = head, q = dummyNode;
        while (p != null) {
            for (int i = 0; i < k; i++) {
                if (p == null) {
                    q.next = head;
                    return dummyNode.next;
                }
                p = p.next;
            }
            ListNode temp = head;
            for (int i = 0; i < k; i++) {
                head = head.next;
                pre.next = q.next;
                q.next = pre;
                pre = head;
            }
            q = temp;
        }
        return dummyNode.next;
    }
}
