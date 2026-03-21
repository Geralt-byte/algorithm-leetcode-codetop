package hot100.linklisted.a3;

import hot100.linklisted.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @create 2026/3/21 13:58
 */
// 1 2 3
public class Solution1 {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode fast=head,slow=head;
        //找到下半链表的起点
        while (fast!=null){
            fast=fast.next;
            if(fast!=null) fast=fast.next;
            slow=slow.next;
        }
        //反转下半链表
        ListNode listNode = reserveListNode(slow);
        //判断是否回文
        boolean judge = judge(head, listNode);
        //恢复下半链表
        reserveListNode(listNode);
        //打印验证
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
        //返回结果
        return judge;
    }

    //判断是否回文
    private boolean judge(ListNode headA,ListNode headB){
        while (headA!=null&&headB!=null){
            if(headA.val!=headB.val) return false;
            headA=headA.next;
            headB=headB.next;
        }
        return true;
    }

    //反转链表
    private ListNode reserveListNode(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode newNode=reserveListNode(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }
}
