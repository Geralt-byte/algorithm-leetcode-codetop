package codetop.page02.a16;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @create 2026/4/20 08:26
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = head, pre = dummyHead;
        while (n > 0 && p != null) {
            p = p.next;
            n--;
        }
        while (p != null) {
            p = p.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }
}
