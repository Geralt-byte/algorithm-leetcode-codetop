package hot100.linklisted.a3;

import hot100.linklisted.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @create 2026/3/21 13:58
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        int i=0,j=list.size()-1;
        while (i<j){
            if(list.get(i)!=list.get(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
