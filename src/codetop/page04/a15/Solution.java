package codetop.page04.a15;

import hot100.linklisted.pojo.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author mlei@xjtu
 * @description 给你一个单链表的头节点 head ，
 * 请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @create 2026/4/30 11:30
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
