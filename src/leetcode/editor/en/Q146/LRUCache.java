package leetcode.editor.en.Q146;

import java.util.*;

//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise 
//return -1. 
// void put(int key, int value) Update the value of the key if the key exists. 
//Otherwise, add the key-value pair to the cache. If the number of keys exceeds 
//the capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10⁴ 
// 0 <= value <= 10⁵ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// 👍 16091 👎 696


//leetcode submit region begin(Prohibit modification and deletion)
class Node {
    public int value;
    int key;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList {

    Node head;
    Node tail;

    int size;

    DoublyLinkedList() {
    }


    public int size() {
        return this.size;
    }

    public void append(Node node) {
        if (this.tail != null) {
            this.tail.next = node;
            node.prev = this.tail;
            node.next = null;
            this.tail = node;
        } else {
            this.head = node;
            this.tail = node;
        }
        size++;
    }

    public void remove(Node node) {
        if (node == this.head) {
            this.head = this.head.next;
            if (this.head != null) this.head.prev = null;
            else this.tail = null;

        } else if (node == this.tail) {
            this.tail = this.tail.prev;
            if (this.tail != null) this.tail.next = null;
            else this.head = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = null;
        size--;
        if (size == 1) this.head = this.tail;
    }

}


public class LRUCache {

    HashMap<Integer, Node> cache = new HashMap<>();
    DoublyLinkedList LRU = new DoublyLinkedList();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            LRU.remove(node);
            LRU.append(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (LRU.size() == capacity && !cache.containsKey(key)) {
            cache.remove(LRU.head.key);
            LRU.remove(LRU.head);
        }
        if (cache.containsKey(key)) {
//            this.get(key); // move to tail
            Node newValue = cache.get(key);
            LRU.remove(newValue);
            LRU.append(newValue);
            newValue.value = value;
        } else {
            Node newValue = new Node(key, value);
            LRU.append(newValue);
            cache.put(key, newValue);
        }

    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
