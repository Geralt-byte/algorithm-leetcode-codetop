package hot100.linklisted.a3;

import hot100.linklisted.pojo.ListNode;

/**
 * @author mlei@xjtu
 * @description Main
 * @create 2026/3/21 14:47
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        ListNode h1=new ListNode(1);
        ListNode h2=new ListNode(2);
        ListNode h3=new ListNode(9);
        ListNode h4=new ListNode(3);
        ListNode h5=new ListNode(2);
        h1.next=h2;
        h2.next=h3;
        h3.next=h4;
        h4.next=h5;
        h5.next=null;
        System.out.println(solution1.isPalindrome(h1));
    }
}
