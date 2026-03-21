package hot100.linklisted.a5;

import hot100.linklisted.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @create 2026/3/21 13:58
 */
public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        //快慢指针
        ListNode fast=head,slow=head;
        while (fast!=null){
            fast=fast.next;
            if(fast==null) break;
            fast=fast.next;
            slow=slow.next;
            if(slow==fast){
                while (true) {
                    if(slow==head) return head;
                    slow=slow.next;
                    head=head.next;
                }
            }
        }
        return null;
    }
}
