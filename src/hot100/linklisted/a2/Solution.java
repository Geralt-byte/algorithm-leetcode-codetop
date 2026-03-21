package hot100.linklisted.a2;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @create 2026/3/21 13:58
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        //头插
        if(head==null) return head;
        ListNode dumpyNode=new ListNode();
        ListNode p=head;
        while (p!=null){
           p=p.next;
           head.next=dumpyNode.next;
           dumpyNode.next=head;
           head=p;
        }
        return dumpyNode.next;
    }
}
