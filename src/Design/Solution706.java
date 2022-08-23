package Design;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 706. 设计哈希映射
 * @Author Hao Chen
 * @Create 2022/8/23 17:45
 */
public class Solution706 {
}
class MyHashMap {
    private class Pair{
        private int val;
        private int key;
        public Pair(int key,int val){
            this.key = key;
            this.val = val;
        }
        public int getKey(){
            return key;
        }
        public int getVal(){
            return val;
        }
        public void setVal(int val){
            this.val = val;
        }
    }

    static final int BASE = 769;
    LinkedList<Pair>[] data;
    public MyHashMap() {
        data = new LinkedList[769];
        for(int i = 0; i < BASE; ++i){
            data[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair> it = data[h].iterator();
        while(it.hasNext()){
            Pair pair = it.next();
            if(pair.getKey() == key){
                pair.setVal(value);
                return;
            }
        }
        data[h].addLast(new Pair(key,value));
    }

    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> it = data[h].iterator();
        while(it.hasNext()){
            Pair pair = it.next();
            if(pair.getKey() == key){
                return pair.getVal();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> it = data[h].iterator();
        while(it.hasNext()){
            Pair pair = it.next();
            if(pair.getKey() == key){
                data[h].remove(pair);
                return;
            }
        }
    }

    public int hash(int key){
        return key % BASE;
    }
}