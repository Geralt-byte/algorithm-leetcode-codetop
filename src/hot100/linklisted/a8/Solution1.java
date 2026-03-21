package hot100.linklisted.a8;

import hot100.linklisted.pojo.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author mlei@xjtu
 * @description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @create 2026/3/21 13:58
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //栈

        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode p=dummy;
        Deque<ListNode> deque=new ArrayDeque<>();
        while (p!=null){
            deque.push(p);
            p=p.next;
        }
        for (int i = 0; i < n; i++) {
            deque.pop();
        }
        ListNode pop = deque.pop();
        pop.next=pop.next.next;
        return dummy.next;
    }
}
