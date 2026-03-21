package hot100.linklisted.a7;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @create 2026/3/21 13:58
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode=new ListNode();
        ListNode p=dummyNode;
        //进位数字
        int nextSum=0;
        while (l1!=null&&l2!=null){
            int sum=l1.val+l2.val+nextSum;
            //两个链表都不为空时，新建节点尾插
            p.next= new ListNode(sum%10);
            p=p.next;
            nextSum=sum/10;
            l1=l1.next;
            l2=l2.next;
        }
        //直接使用剩余的链表
        if(l1!=null) p.next=l1;
        if(l2!=null) p.next=l2;
        //为处理最后的进位需要记录前驱
        ListNode pre=p;
        p=p.next;
        //为空可能是剩余链表遍历完或两个链表同时遍历完
        while (p!=null){
            int sum=p.val+nextSum;
            p.val=sum%10;
            nextSum=sum/10;
            //发现下一个进位为0可以直接返回
            if(nextSum==0) break;
            pre=p;
            p=p.next;
        }
        //处理最后进位
        if(nextSum>0){
            pre.next= new ListNode(nextSum);
        }
        return dummyNode.next;
    }
}
