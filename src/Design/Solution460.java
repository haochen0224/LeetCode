package Design;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU 缓存
 * @Author Hao Chen
 * @Create 2022/8/8 21:57
 */
public class Solution460 {
}
class LFUCache {
    int capacity;
    int minFreq;
    Map<Integer,DoublyLinkedList> freqMap;
    Map<Integer,Node> keyMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        freqMap = new HashMap<>();
        keyMap = new HashMap<>();
    }

    public int get(int key) {
        if(capacity == 0){
            return -1;
        }
        if(!keyMap.containsKey(key)){
            return -1;
        }
        Node node = keyMap.get(key);
        int value = node.value;
        int freq = node.freq;
        freqMap.get(freq).remove(node);
        if(freqMap.get(freq).size == 0){
            freqMap.remove(freq);
            if(freq == minFreq){
                ++minFreq;
            }
        }
        DoublyLinkedList list = freqMap.getOrDefault(freq+1,new DoublyLinkedList());
        list.addToHead(new Node(key,value,freq+1));
        freqMap.put(freq+1,list);
        keyMap.put(key,list.getHead());
        // keyMap.put(key,freqMap.get(freq+1).getHead());
        return value;
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(!keyMap.containsKey(key)){
            if(keyMap.size() == capacity){
                Node tail = freqMap.get(minFreq).getTail();
                freqMap.get(minFreq).remove(tail);
                keyMap.remove(tail.key);
                if(freqMap.get(minFreq).size == 0){
                    freqMap.remove(minFreq);
                }
            }
            DoublyLinkedList list = freqMap.getOrDefault(1,new DoublyLinkedList());
            list.addToHead(new Node(key,value,1));
            freqMap.put(1,list);
            keyMap.put(key,list.getHead());
            //  keyMap.put(key,freqMap.get(1).getHead());
            minFreq = 1;
        }else{
            Node node = keyMap.get(key);
            int freq = node.freq;
            freqMap.get(freq).remove(node);
            if(freqMap.get(freq).size == 0){
                freqMap.remove(freq);
                if(freq == minFreq){
                    ++minFreq;
                }
            }
            DoublyLinkedList list = freqMap.getOrDefault(freq+1,new DoublyLinkedList());
            list.addToHead(new Node(key,value,freq+1));
            freqMap.put(freq+1,list);
            keyMap.put(key,list.getHead());
            //  keyMap.put(key,freqMap.get(freq+1).getHead());
        }
    }
}
class Node{
    int key;
    int value;
    int freq;
    Node prev;
    Node next;
    public Node(){
        this(-1,-1,0);
    }
    public Node(int key,int value,int freq){
        this.key = key;
        this.value = value;
        this.freq = freq;
    }
}
class DoublyLinkedList{
    int size;
    Node dummyHead;
    Node dummyTail;
    public DoublyLinkedList(){
        size = 0;
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    public void addToHead(Node node){
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        ++size;
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        --size;
    }
    public Node getHead(){
        return dummyHead.next;
    }
    public Node getTail(){
        return dummyTail.prev;
    }
}