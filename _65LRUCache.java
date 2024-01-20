import java.util.LinkedHashMap;
import java.util.Map;

/*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.



Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]
*/
public class _65LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;

    public _65LRUCache(int capacity) {
        this.capacity = capacity;
        //using linkedHashMap to maintain insertion order
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        //return the value for the key, or -1 if it is not present
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        //update the value for the key in the cache
        cache.put(key, value);

        //check if capacity is exceeded after the put operation
        if(cache.size() > capacity){
            //remove the oldest entry
            cache.remove(cache.keySet().iterator().next());
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//capacity: 2
//     [4, 4] [3, 3] [2, 2]
