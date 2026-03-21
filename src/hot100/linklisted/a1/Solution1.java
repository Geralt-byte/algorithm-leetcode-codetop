package hot100.linklisted.a1;

import hot100.linklisted.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @create 2026/3/21 13:34
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //hash
        Set<ListNode> set=new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while (headB!=null){
            if(set.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}
