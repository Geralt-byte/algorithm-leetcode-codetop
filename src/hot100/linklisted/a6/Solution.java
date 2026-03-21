package hot100.linklisted.a6;

import hot100.linklisted.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @create 2026/3/21 13:58
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //尾插法
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode dummyNode=new ListNode();
        ListNode p=dummyNode;
        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                p.next=list1;
                list1=list1.next;
                p=p.next;
            }else if(list1.val>list2.val){
                p.next=list2;
                list2=list2.next;
                p=p.next;
            }else {
                p.next=list1;
                list1=list1.next;
                p=p.next;
                p.next=list2;
                list2=list2.next;
                p=p.next;
            }
        }
        if(list1!=null){
            p.next=list1;
        }else if(list2!=null){
            p.next=list2;
        }
        return dummyNode.next;
    }
}
