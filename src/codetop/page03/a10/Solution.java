package codetop.page03.a10;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @create 2026/4/22 10:28
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        int temp = 0;
        while (l1 != null && l2 != null) {
            temp = temp + l1.val + l2.val;
            p.next = new ListNode(temp % 10);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
            temp /= 10;
        }
        ListNode q = null;
        if (l1 != null) {
            q = l1;
        }
        if (l2 != null) {
            q = l2;
        }
        p.next = q;
        while (q != null && temp != 0) {
            temp = temp + q.val;
            q.val = temp % 10;
            p = q;
            q = q.next;
            temp /= 10;
        }
        if (temp != 0) {
            p.next = new ListNode(temp);
        }
        return dummyHead.next;
    }
}
