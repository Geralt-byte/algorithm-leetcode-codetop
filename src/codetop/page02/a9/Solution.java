package codetop.page02.a9;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @create 2026/4/18 11:11
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != null && b != null) {
            a = a.next;
            b = b.next;
        }
        ListNode p1, p2;
        if (a != null) {
            p1 = headA;
            p2 = headB;
        } else {
            p1 = headB;
            p2 = headA;
            a = b;
        }
        while (a != null) {
            a = a.next;
            p1 = p1.next;
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
