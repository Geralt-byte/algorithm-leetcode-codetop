package hot100.linklisted.a10;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @create 2026/3/21 13:58
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        //pre和p分别记录已处理节点的尾节点和未处理节点的头节点
        ListNode dummyNode=new ListNode();
        ListNode pre=dummyNode;
        ListNode p=head;
        while (true){
            //temp尝试向后移动k次
            ListNode temp=p;
            for (int i = 0; i < k; i++) {
                temp=temp.next;
                //当最后一次temp为空说明链表可以被k整除且当前是最后一段，翻转最后一段并返回
                if(i==k-1&&temp==null){
                    reserve(pre, p, k);
                    return dummyNode.next;
                }
                //当没有达到最后一次temp为空说明链表不可以被k整除，将最后一段连接，并返回
                if(i<k-1&&temp==null){
                    pre.next=p;
                    return dummyNode.next;
                }
            }
            //temp不为空，说明还有剩余段，先翻转并将pre调整到已处理链表的尾节点，再将p调整到下一段的起点
            pre = reserve(pre, p, k);
            p=temp;
        }
    }

    //使用头插法将head依次插入last完成翻转，并返回翻转后链表的最后一个节点
    private ListNode reserve(ListNode last,ListNode head,int k){
        ListNode newLast=head;
        ListNode p;
        for (int i = 0; i < k; i++) {
            p=head.next;
            head.next=last.next;
            last.next=head;
            head=p;
        }
        return newLast;
    }
}
