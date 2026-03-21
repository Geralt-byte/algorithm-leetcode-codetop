package hot100.linklisted.a12;

import hot100.linklisted.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @create 2026/3/21 13:58
 */
public class Solution1 {
    public ListNode sortList(ListNode head) {
        //手写快排
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        quickSort(list,0, list.size()-1);
        ListNode dummyNode = new ListNode();
        ListNode next = dummyNode;
        for (ListNode listNode : list) {
            next.next = listNode;
            next = listNode;
        }
        next.next = null;
        return dummyNode.next;
    }

    private void quickSort(List<ListNode> list, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(list, left, right);
            quickSort(list, left, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, right);
        }
    }

    private int partition(List<ListNode> list, int left, int right) {
        ListNode pivot=list.get(left);
        while (left < right) {
            while (left < right && list.get(right).val >= pivot.val) right--;
            if (left < right) {
                list.set(left,list.get(right));
                left++;
            }
            while (left < right && list.get(left).val <= pivot.val) left++;
            if (left < right) {
                list.set(right,list.get(left));
                right--;
            }
        }
        list.set(left,pivot);
        return left;
    }
}
