package codetop.page05.a12;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @create 2026/5/7 14:19
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode();
        ListNode p = head, pre;
        ListNode tail = dummyHead;
        while (p != null) {
            pre = p;
            if (p.next == null) {
                tail.next = p;
                break;
            } else p = p.next.next;
            tail.next = pre.next;
            tail=tail.next;
            tail.next = pre;
            tail = tail.next;
            tail.next = null;
        }
        return dummyHead.next;
    }
}
