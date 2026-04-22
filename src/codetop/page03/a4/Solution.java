package codetop.page03.a4;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @create 2026/4/21 09:06
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        return merge(left, right);
    }

    private ListNode merge(ListNode headA, ListNode headB) {
        if (headA == null) return headB;
        if (headB == null) return headA;
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        while (headA != null && headB != null) {
            if (headA.val <= headB.val) {
                p.next = headA;
                headA = headA.next;
                p = p.next;
                p.next = null;
            } else {
                p.next = headB;
                headB = headB.next;
                p = p.next;
            }
        }
        if (headA != null) p.next = headA;
        if (headB != null) p.next = headB;
        return dummyHead.next;
    }
}
