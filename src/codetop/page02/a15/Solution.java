package codetop.page02.a15;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * @create 2026/4/19 09:25
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode();
        ListNode q = dummyHead;
        ListNode pre = head, p = head;
        while (p != null) {
            int value = p.val;
            int count = 0;
            while (p != null && p.val == value) {
                count++;
                p = p.next;
            }
            if (count == 1) {
                q.next = pre;
                q = q.next;
                q.next = null;
            }
            pre = p;
        }
        return dummyHead.next;
    }
}
