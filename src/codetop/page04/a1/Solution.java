package codetop.page04.a1;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号对应的节点。
 * @create 2026/4/27 07:18
 */
public class Solution {
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode p = head;
        ListNode pre = head;
        for (int i = 0; i < cnt; i++) {
            if (p != null) {
                p = p.next;
            } else break;
        }
        while (p != null) {
            p = p.next;
            pre = pre.next;
        }
        return pre;
    }
}
