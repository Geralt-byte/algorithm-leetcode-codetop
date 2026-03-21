package hot100.linklisted.a11;

import hot100.linklisted.pojo.Node;

import java.util.HashMap;
import java.util.Map;


/**
 * @author mlei@xjtu
 * @description 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * @create 2026/3/21 13:58
 */
public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Integer> sourseMap=new HashMap<>();
        Map<Integer,Node> destineMap=new HashMap<>();
        Node dummy=new Node(0);
        Node p=dummy;
        int index=0;
        Node q=head;
        while (q!=null){
            Node node = new Node(q.val);
            p.next=node;
            p=node;
            sourseMap.put(q,index);
            destineMap.put(index,node);
            index++;
            q=q.next;
        }
        p=dummy.next;
        while (head!=null){
            if (sourseMap.containsKey(head.random)) {
                Integer i = sourseMap.get(head.random);
                p.random=destineMap.get(i);
            }
            head=head.next;
            p=p.next;
        }
        return dummy.next;
    }
}
