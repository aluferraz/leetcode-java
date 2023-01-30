package leetcode.editor.en.Q460;

import javafx.util.Pair;

import java.util.*;

//Design and implement a data structure for a Least Frequently Used (LFU) cache.
//
//
// Implement the LFUCache class:
//
//
// LFUCache(int capacity) Initializes the object with the capacity of the data
//structure.
// int get(int key) Gets the value of the key if the key exists in the cache.
//Otherwise, returns -1.
// void put(int key, int value) Update the value of the key if present, or
//inserts the key if not already present. When the cache reaches its capacity, it
//should invalidate and remove the least frequently used key before inserting a new
//item. For this problem, when there is a tie (i.e., two or more keys with the same
//frequency), the least recently used key would be invalidated.
//
//
// To determine the least frequently used key, a use counter is maintained for
//each key in the cache. The key with the smallest use counter is the least
//frequently used key.
//
// When a key is first inserted into the cache, its use counter is set to 1 (
//due to the put operation). The use counter for a key in the cache is incremented
//either a get or put operation is called on it.
//
// The functions get and put must each run in O(1) average time complexity.
//
//
// Example 1:
//
//
//Input
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get",
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//Explanation
//// cnt(x) = the use counter for key x
//// cache=[] will show the last used order for tiebreakers (leftmost element
//is  most recent)
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // return 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest,
//invalidate 2.
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1
//.
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // return 4
//                 // cache=[4,3], cnt(4)=2, cnt(3)=3
//
//
//
// Constraints:
//
//
// 0 <= capacity <= 10⁴
// 0 <= key <= 10⁵
// 0 <= value <= 10⁹
// At most 2 * 10⁵ calls will be made to get and put.
//
//
//
//
//
// 👍 3937 👎 241


//leetcode submit region begin(Prohibit modification and deletion)

public class LFUCache {

    HashMap<Integer, LinkedHashSet<Integer>> frequencies = new HashMap<>();
    HashMap<Integer, Pair<Integer, Integer>> keysValueFrequency = new HashMap<>();
    int capacity;
    int minFrequency = Integer.MAX_VALUE;


    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keysValueFrequency.containsKey(key)) {
            int value = keysValueFrequency.get(key).getKey();
            put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Pair<Integer, Integer> keyInfo = keysValueFrequency.getOrDefault(key, new Pair<>(value, 0));
        int frequency = keyInfo.getValue();
        purge(key);
        removeFromFrequency(key, frequency);
        frequency++;
        keysValueFrequency.put(key, new Pair<>(value, frequency));
        addToFrequency(key, frequency);
    }

    private void purge(int key) {
        if (keysValueFrequency.size() == capacity && !keysValueFrequency.containsKey(key)) { // New value
            minFrequency = getMinFrequency();
            int LRUValue = frequencies.get(minFrequency).iterator().next();
            removeFromFrequency(LRUValue, minFrequency);
        }
    }

    private void addToFrequency(int key, int frequency) {
        frequencies.computeIfAbsent(frequency, (k) -> new LinkedHashSet<>()).add(key);
        minFrequency = Math.min(frequency, minFrequency);
    }

    private void removeFromFrequency(int key, int frequency) {
        if (frequencies.containsKey(frequency)) {
            HashSet<Integer> valuesInFreq = frequencies.get(frequency);
            valuesInFreq.remove(key);
            keysValueFrequency.remove(key);
            if (valuesInFreq.isEmpty()) {
                frequencies.remove(frequency);
                if (frequency == minFrequency) {
                    minFrequency = Integer.MAX_VALUE;
                }
            }
        }
    }

    private int getMinFrequency() {
        return minFrequency;
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
