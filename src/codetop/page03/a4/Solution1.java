package codetop.page03.a4;

import hot100.linklisted.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author mlei@xjtu
 * @description 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @create 2026/4/21 09:06
 */
public class Solution1 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        quickSort(list, 0, list.size() - 1);
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        for (ListNode listNode : list) {
            p.next = listNode;
            p = p.next;
        }
        p.next = null;
        return dummyHead.next;
    }

    private void quickSort(List<ListNode> list, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(list, left, right);
            quickSort(list, left, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, right);
        }
    }

    private int partition(List<ListNode> list, int left, int right) {
        if (left == right) return left;
        Random random = new Random();
        int randomIndex = left + random.nextInt(right - left + 1);
        ListNode temp = list.get(randomIndex);
        list.set(randomIndex, list.get(left));
        list.set(left, temp);
        ListNode pivot = list.get(left);
        while (left < right) {
            while (left < right && list.get(right).val >= pivot.val) right--;
            if (left<right) {
                list.set(left, list.get(right));
                left++;
            }
            while (left < right && list.get(left).val <= pivot.val) left++;
            if (left<right) {
                list.set(right, list.get(left));
                right--;
            }
        }
        list.set(left, pivot);
        return left;
    }
}
