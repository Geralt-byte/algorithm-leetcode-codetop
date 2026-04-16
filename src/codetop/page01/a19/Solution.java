package codetop.page01.a19;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * @create 2026/4/16 14:08
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        //统一处理头节点
        head=dummyNode;
        //寻找翻转链表部分的前一个节点
        for (int i = 0; i < left - 1; i++) {
            head = head.next;
        }
        //翻转最后一个节点，直接返回
        if(head.next==null) return dummyNode.next;
        //pre做头插，p保留剩余链位置，newTail存储翻转后的末尾
        ListNode pre = head.next;
        ListNode p = head.next;
        ListNode newTail = head.next;
        //断开第一段链表
        head.next = null;
        //头插
        for (int i = 0; i < right - left + 1; i++) {
            p = p.next;
            pre.next = head.next;
            head.next = pre;
            pre = p;
        }
        //连接最后一段
        newTail.next = p;
        return dummyNode.next;
    }
}
