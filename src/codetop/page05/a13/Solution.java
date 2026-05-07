package codetop.page05.a13;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * @create 2026/5/7 14:34
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head, pre = head;
        while (p != null) {
            while (p != null && p.val == pre.val) {
                p = p.next;
            }
            pre.next = p;
            pre = p;
        }
        return head;
    }
}
