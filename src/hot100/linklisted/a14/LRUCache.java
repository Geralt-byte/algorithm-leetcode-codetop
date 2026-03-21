package hot100.linklisted.a14;

import hot100.linklisted.pojo.ListNode;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
 * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * @create 2026/3/21 13:58
 */
public class LRUCache {

    private static class DListNode{
        private int key;
        private int value;
        private DListNode next;
        private DListNode prev;

        public DListNode() {
        }

        public DListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DListNode(int key, int value, DListNode next, DListNode prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private final Map<Integer,DListNode> cacheMap=new HashMap<>();
    private final DListNode dummyNode;
    private final int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        size=0;
        dummyNode=new DListNode();
        dummyNode.next=dummyNode;
        dummyNode.prev=dummyNode;
    }

    public int get(int key) {
        if(cacheMap.containsKey(key)){
            move(cacheMap.get(key));
            return dummyNode.next.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            move(cacheMap.get(key));
            dummyNode.next.value=value;
        }else {
            if(size>=capacity){
                DListNode p = removeTail();
                cacheMap.remove(p.key);
            }
            DListNode node = new DListNode(key, value);
            insertFront(node);
            cacheMap.put(key,node);
        }

    }

    private void insertFront(DListNode node){
        size++;
        node.next=dummyNode.next;
        dummyNode.next.prev=node;
        dummyNode.next=node;
        node.prev=dummyNode;
    }

    private void move(DListNode node){
        DListNode p = remove(node);
        insertFront(p);
    }

    private DListNode remove(DListNode node){
        size--;
        node.prev.next=node.next;
        node.next.prev=node.prev;
        return node;
    }

    private DListNode removeTail(){
        return remove(dummyNode.prev);
    }
}
