package hot100.linklisted.a12;

import hot100.linklisted.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @create 2026/3/21 13:58
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        //利用集合排序
        List<ListNode> list=new ArrayList<>();
        ListNode p=head;
        while (p!=null){
           list.add(p);
           p=p.next;
        }
        list.sort((node1, node2) -> node1.val - node2.val);
        ListNode dummyNode=new ListNode();
        ListNode next=dummyNode;
        for (ListNode listNode : list) {
            next.next=listNode;
            next=listNode;
        }
        next.next=null;
        return dummyNode.next;
    }
}
