package List;

/**
 * 707. 设计链表
 */
public class Solution707 {
}

class MyLinkedList {
    public class ListNode{
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int x){val = x;}
    }
    int size;
    ListNode head;
    ListNode tail;
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode curr;
        if(index + 1 < size - index){
            curr = head;
            for(int i = 0; i < index+1; ++i){
                curr = curr.next;
            }
        }else{
            curr = tail;
            for(int i = 0; i < size-index; ++i){
                curr = curr.prev;
            }
        }
        return curr.val;
    }


    public void addAtHead(int val) {
        ListNode toAdd = new ListNode(val);
        ++size;
        ListNode prev = head;
        ListNode succ = head.next;
        toAdd.prev = prev;
        toAdd.next = succ;
        prev.next = toAdd;
        succ.prev = toAdd;
    }

    public void addAtTail(int val) {
        ListNode toAdd = new ListNode(val);
        ++size;
        ListNode prev = tail.prev;
        ListNode succ = tail;
        toAdd.next = succ;
        toAdd.prev = prev;
        succ.prev = toAdd;
        prev.next = toAdd;
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }
        if(index < 0){
            addAtHead(val);
            return;
        }
        // if(index < 0){
        //     index = 0;
        // }
        ListNode toAdd = new ListNode(val);
        ListNode prev, succ;
        if(index < size-index){
            prev = head;
            for(int i = 0; i < index; ++i){
                prev = prev.next;
            }
            succ = prev.next;
        }else{
            succ = tail;
            for(int i = 0; i < size-index; ++i){
                succ = succ.prev;
            }
            prev = succ.prev;
        }
        ++size;
        toAdd.next = succ;
        toAdd.prev = prev;
        prev.next = toAdd;
        succ.prev = toAdd;
    }


    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        ListNode prev, succ;
        if(index < size-index){
            prev = head;
            for(int i = 0; i < index; ++i){
                prev = prev.next;
            }
            succ = prev.next.next;
        }else{
            succ = tail;
            for(int i = 0; i < size-index-1; ++i){
                succ = succ.prev;
            }
            prev = succ.prev.prev;
        }
        --size;
        prev.next = succ;
        succ.prev = prev;
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
