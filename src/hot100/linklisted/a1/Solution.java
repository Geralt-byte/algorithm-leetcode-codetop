package hot100.linklisted.a1;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @create 2026/3/21 13:34
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA=0,lengthB=0;
        ListNode pA=headA,pB=headB;
        while (pA!=null){
            pA=pA.next;
            lengthA++;
        }
        while (pB!=null){
            pB=pB.next;
            lengthB++;
        }
        pA=headA;
        pB=headB;
        if(lengthA>lengthB){
            for (int i = 0; i < lengthA-lengthB; i++) {
                pA=pA.next;
            }
        }
        if(lengthA<lengthB){
            for (int i = 0; i < lengthB-lengthA; i++) {
                pB=pB.next;
            }
        }
        while (pA!=null&&pB!=null){
            if(pA==pB) return pA;
            pA=pA.next;
            pB=pB.next;
        }
        return null;
    }
}
