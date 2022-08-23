package Design;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 * @Author Hao Chen
 * @Create 2022/8/23 17:34
 */
public class Solution705 {
}
class MyHashSet {
    static final int BASE = 769;
    LinkedList<Integer>[] data;
    public MyHashSet() {
        data = new LinkedList[769];
        for(int i = 0; i < BASE; ++i){
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> it = data[h].iterator();
        while(it.hasNext()){
            Integer element = it.next();
            if(element == key){
                return;
            }
        }
        data[h].addLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> it = data[h].iterator();
        while(it.hasNext()){
            Integer element = it.next();
            if(element == key){
                data[h].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> it = data[h].iterator();
        while(it.hasNext()){
            Integer element = it.next();
            if(element == key){
                return true;
            }
        }
        return false;
    }

    private int hash(int key){
        return key % BASE;
    }
}
