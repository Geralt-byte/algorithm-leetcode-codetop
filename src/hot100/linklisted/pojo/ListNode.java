package hot100.linklisted.pojo;

/**
 * @author mlei@xjtu
 * @description ListNode
 * @create 2026/3/21 13:36
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
