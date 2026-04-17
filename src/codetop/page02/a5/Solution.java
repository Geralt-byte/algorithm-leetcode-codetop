package codetop.page02.a5;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @create 2026/4/17 14:10
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        if (left + 1 == right) {
            return merge(lists[left], lists[right]);
        }
        int mid = (left + right) / 2;
        ListNode node1 = mergeSort(lists, left, mid);
        ListNode node2 = mergeSort(lists, mid + 1, right);
        return merge(node1, node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyNode = new ListNode();
        ListNode p = dummyNode;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                p.next = node1;
                p = p.next;
                node1 = node1.next;
            } else {
                p.next = node2;
                p = p.next;
                node2 = node2.next;
            }
        }
        if (node1 != null) {
            p.next = node1;
        }
        if (node2 != null) {
            p.next = node2;
        }
        return dummyNode.next;
    }
}
