package hot100.linklisted.a8;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @create 2026/3/21 13:58
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针

        //使用虚拟头节点简化头节点的处理逻辑
        ListNode dummyNode=new ListNode();
        dummyNode.next=head;
        ListNode pre=dummyNode,p=dummyNode;
        for (int i = 0; i < n; i++) {
            p=p.next;
        }
        while (p.next!=null){
            p=p.next;
            pre=pre.next;
        }
        if (pre.next != null) {
            pre.next=pre.next.next;
        }
        return dummyNode.next;
    }
}
