package COMPANY.ByteDance;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * @Author Hao Chen
 * @Create 2022/7/21 22:36
 */
public class Solution146 {
}
class LRUCache {
    int size;
    int capacity;
    DLinkedNode head;
    DLinkedNode tail;
    Map<Integer,DLinkedNode> cache;
    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            node = new DLinkedNode(key,value);
            cache.put(key,node);
            addToHead(node);
            ++size;
            if(size > capacity){
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
                --size;
            }
        }else{
            node.val = value;
            moveToHead(node);
        }
    }
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    private void removeNode(DLinkedNode node){
        DLinkedNode prevNode = node.prev;
        DLinkedNode nextNode = node.next;
        prevNode.next = node.next;
        nextNode.prev = node.prev;
    }
    private void addToHead(DLinkedNode node){
        DLinkedNode nextNode = head.next;
        node.prev = head;
        node.next = nextNode;
        head.next = node;
        nextNode.prev = node;
    }
}
class DLinkedNode{
    int key;
    int val;
    DLinkedNode prev;
    DLinkedNode next;
    public DLinkedNode(){}
    public DLinkedNode(int key,int val){
        this.key = key;
        this.val = val;
    }
}
