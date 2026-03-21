package hot100.linklisted.a13;

import hot100.linklisted.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @create 2026/3/21 13:58
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists,0,lists.length-1);
    }

    //递归合并整个链表
    private ListNode mergeList(ListNode[] lists, int left, int right) {
        if(left>right) return null;
        if (left == right) return merge(lists[left],null);
        if (left + 1 == right) {
            return merge(lists[left], lists[right]);
        }
        int mid = (left + right) / 2;
        ListNode headA = mergeList(lists, left, mid);
        ListNode headB = mergeList(lists, mid + 1, right);
        return merge(headA,headB);
    }

    //合并两个链表
    private ListNode merge(ListNode headA, ListNode headB) {
        if (headA == null) return headB;
        if (headB == null) return headA;
        ListNode dummyNode = new ListNode();
        ListNode p = dummyNode;
        while (headA != null && headB != null) {
            if (headA.val <= headB.val) {
                p.next = headA;
                headA = headA.next;
                p = p.next;
            } else {
                p.next = headB;
                headB = headB.next;
                p = p.next;
            }
        }
        if (headA != null) p.next = headA;
        if (headB != null) p.next = headB;
        return dummyNode.next;
    }
}
