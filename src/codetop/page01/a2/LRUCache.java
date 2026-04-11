package codetop.page01.a2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mlei@xjtu
 * @description 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * @create 2026/4/11 18:09
 */
public class LRUCache {

    private static class DListNode {
        private int key;
        private int value;
        private DListNode prev;
        private DListNode next;

        public DListNode(int key, int value, DListNode prev, DListNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public DListNode() {
        }
    }

    private int size;
    private final int capacity;
    private final Map<Integer, DListNode> map;
    private final DListNode dummyNode;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        dummyNode = new DListNode();
        dummyNode.next = dummyNode;
        dummyNode.prev = dummyNode;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DListNode node = map.get(key);
            moveToHead(node);
            return node.value;
        } else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DListNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (size >= capacity) {
                DListNode node = deleteTail();
                map.remove(node.key);
            }
            DListNode node = new DListNode();
            node.key=key;
            node.value = value;
            map.put(key, node);
            insertToHead(node);
        }
    }

    private void moveToHead(DListNode node) {

        DListNode p = remove(node);

        insertToHead(p);
    }

    private DListNode deleteTail() {
        return remove(dummyNode.prev);
    }

    private DListNode remove(DListNode node){
        size--;
        node.prev.next=node.next;
        node.next.prev=node.prev;
        return node;
    }

    private void insertToHead(DListNode node) {
        size++;

        node.next = dummyNode.next;
        dummyNode.next.prev = node;
        dummyNode.next = node;
        node.prev = dummyNode;
    }
}
