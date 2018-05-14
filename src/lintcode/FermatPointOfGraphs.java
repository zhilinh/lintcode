package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * NOT WORKING! 
 */
public class FermatPointOfGraphs {
	/**
     * @param x: The end points set of edges
     * @param y: The end points set of edges
     * @param d: The length of edges
     * @return: Return the index of the fermat point
     */
    public int getFermatPoint(int[] x, int[] y, int[] d) {
        // Write your code here
    	int s1 = 0, s2 = 0, index = 0, max = 0, s1Num = -1, s2Num = -1;
    	Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
    	for (int i = 0; i < d.length; i++) {
    		if (graph.containsKey(x[i])) {
    			graph.get(x[i]).add(y[i]);
    		} else {
    			List<Integer> tmp = new ArrayList<Integer>();
    			tmp.add(y[i]);
    			graph.put(x[i], tmp);
    		}
    		
    		if (graph.containsKey(y[i])) {
    			graph.get(y[i]).add(x[i]);
    		} else {
    			List<Integer> tmp = new ArrayList<Integer>();
    			tmp.add(x[i]);
    			graph.put(y[i], tmp);
    		}
    		
    		if (d[i] > max) {
    			max = d[i];
    			s1 = x[i];
    			s2 = y[i];
    		}
    	}
    	
    	Map<Integer, Integer> trace = new HashMap<Integer, Integer>();
    	trace.put(s2, 1);
    	
    	Queue<Integer> nodes = new LinkedList<Integer>();
    	nodes.add(s1);
    	while (!nodes.isEmpty()) {
    		int curr = nodes.poll();
    		trace.put(curr, 1);
    		for (int tmp : graph.get(curr)) {
    			if (!trace.containsKey(tmp)) {
    				nodes.add(tmp);
    			}
    		}
    		s1Num++;
    	}
    	
    	trace = new HashMap<Integer, Integer>();
    	trace.put(s1, 1);
    	
    	nodes = new LinkedList<Integer>();
    	nodes.add(s2);
    	while (!nodes.isEmpty()) {
    		int curr = nodes.poll();
    		trace.put(curr, 1);
    		for (int tmp : graph.get(curr)) {
    			if (!trace.containsKey(tmp)) {
    				nodes.add(tmp);
    			}
    		}
    		s2Num++;
    	}
    	if (s1Num == s2Num) {
    		index = s1 < s2 ? s1 : s2;
    	} else {
    		index = s1Num < s2Num ? s1 : s2;
    	}
    	return index;
    }
}
