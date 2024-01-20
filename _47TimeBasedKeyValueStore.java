import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".


Example 1:

Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"*/
public class _47TimeBasedKeyValueStore {
    HashMap<String, ArrayList<Pair>> map;

    //Inner class representing a pair of value and timestamp
    class Pair implements Comparable<Pair>{
        String value;
        int timestamp;

        public Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }

        //compate method for sorting pair objects based on timestamps
        public int compareTo(Pair o){
            return this.timestamp - o.timestamp;
        }
    }


    //constructor initializes the map
    public _47TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    //method to add a new timestamp-value pair for a key
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            //if key is already present, add a new Pair to the existing list
            map.get(key).add(new Pair(value, timestamp));
        }else{
            //if key is not present, create a new pair and add it to a new list
            Pair p = new Pair(value, timestamp);
            map.put(key, new ArrayList<Pair>());
            map.get(key).add(p);
        }
    }

    public String get(String key, int timestamp) {
        //base case: if key is not available return an empty string
        if(map.get(key) == null){
            return "";
        }

        List<Pair> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        int largestPrev = -1;

        //binary search to find the largest timestamp less than or equal to the given timestamp
        while(left <= right){
            int mid = left + (right - left)/2;
            Pair current = list.get(mid);

            if(current.timestamp == timestamp){
                return current.value;
            }else if(current.timestamp < timestamp){
                left = mid+1;
                largestPrev = Math.max(largestPrev, mid);
            }else{
                right = mid - 1;
            }
        }

        //return the value associated with the largest timestamp less than or equal to the given timestamp
        return largestPrev == -1? "": list.get(largestPrev).value;
    }
}

// Class monitor, rohit, 1st
//class monitor, mohit, 6th
//class monitor, mahesh, 15th

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
