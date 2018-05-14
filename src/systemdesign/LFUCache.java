package systemdesign;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/***
 * When a key is updated, it's frequency should also increase by 1.
 * When you update a key, the size shouldn't be changed.
 * @author zhilinh
 *
 */

public class LFUCache {
	
	int capacity = 0;
	int maxFreq = 1;
	Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
	Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
	Map<Integer, Queue<Integer>> freqList = new HashMap<Integer, Queue<Integer>>();
	
    /*
    * @param capacity: An integer
    */public LFUCache(int capacity) {
        // do initialization if necessary
    	this.capacity = capacity;
    	freqList.put(1, new LinkedList<Integer>());
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (valueMap.containsKey(key)) {
			valueMap.put(key, value);
			get(key);
			return;
		}
    	if (valueMap.size() >= capacity) {
    		for (int i = 1; i < maxFreq + 1; i++) {
    			if (!freqList.get(i).isEmpty()) {
    				int tmp = freqList.get(i).poll();
    				valueMap.remove(tmp);
    				freqMap.remove(tmp);
    				break;
    			}
    		}    		
    	}
    	valueMap.put(key, value);
		freqMap.put(key, 1);
		freqList.get(1).add(key);
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
    	if (!valueMap.containsKey(key)) {
    		return -1;
    	}
    	int freq = freqMap.get(key);
    	freqList.get(freq).remove(key);
    	if (!freqList.containsKey(freq + 1)) {    		
    		freqList.put(freq + 1, new LinkedList<Integer>());
    	}
    	freqList.get(freq + 1).add(key);
    	freqMap.put(key, freq + 1);
    	maxFreq = freq + 1 > maxFreq ? freq + 1 : maxFreq;
    	return valueMap.get(key);
    }
}
