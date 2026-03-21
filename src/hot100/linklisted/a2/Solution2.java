package hot100.linklisted.a2;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @create 2026/3/21 13:58
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        //递归
        if(head==null||head.next==null) return head;
        ListNode newNode=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }
}
