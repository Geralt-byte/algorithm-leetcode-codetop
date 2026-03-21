package hot100.linklisted.a12;

import hot100.linklisted.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @create 2026/3/21 13:58
 */
public class Solution2 {
    public ListNode sortList(ListNode head) {
        //归并排序
        if(head==null||head.next==null) return head;
        ListNode slow=head,fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        ListNode headLeft = sortList(head);
        ListNode headRight = sortList(temp);
        return merge(headLeft, headRight);
    }

    private ListNode merge(ListNode headA,ListNode headB){
        if(headA==null) return headB;
        if(headB==null) return headA;
        ListNode dummy=new ListNode();
        ListNode p=dummy;
        while (headA!=null&&headB!=null){
            if(headA.val<=headB.val){
                p.next=headA;
                headA=headA.next;
                p=p.next;
            }else {
                p.next=headB;
                headB=headB.next;
                p=p.next;
            }
        }
        if(headA!=null){
            p.next=headA;
        }
        if(headB!=null){
            p.next=headB;
        }
        return dummy.next;
    }

}
