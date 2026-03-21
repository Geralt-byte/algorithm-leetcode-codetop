package hot100.linklisted.a9;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @create 2026/3/21 13:58
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode();
        dummy.next=head;
        //pre处在已处理链表的尾节点，p处在未处理链表的头节点
        ListNode pre=dummy;
        ListNode p=dummy.next;
        //p.next不为空说明剩余链表的元素至少2个，需要处理
        while (p.next!=null){
            //记录p的下个位置
            ListNode temp=p.next.next;
            //完成翻转，调整pre的位置
            pre = reserveTwo(pre, p);
            //说明剩余链表为空，直接返回
            if(temp==null) return dummy.next;
            //p调整位置
            p=temp;
        }
        //说明链表总数为奇数，还剩一个元素没有处理
        pre.next=p;
        return dummy.next;
    }

    //将以head为头的链表翻转2个节点后尾插入last，并返回新链表的尾节点
    private ListNode reserveTwo(ListNode last,ListNode head){
        last.next=head.next;
        head.next.next=head;
        head.next=null;
        return head;
    }
}
