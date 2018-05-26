package lintcode;

import java.util.*;

public class Tree {
	
	/**
     * @param x: The x
     * @param y: The y
     * @param a: The a
     * @param b: The b
     * @return: The Answer
     */
    public int[] tree(int[] x, int[] y, int[] a, int[] b) {
        // Write your code here
    	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    	Map<Integer, Integer> edges = new HashMap<Integer, Integer>();
    	Queue<Integer> queue = new LinkedList<Integer>();
    	Set<Integer> set = new HashSet<Integer>();
    	int[] ans = new int[a.length];
    	
    	for (int i = 0; i < x.length; i++) {
    		if (!map.containsKey(x[i])) {
    			map.put(x[i], new ArrayList<Integer>());
    		}
    		if (!map.containsKey(y[i])) {
    			map.put(y[i], new ArrayList<Integer>());
    		}
    		map.get(x[i]).add(y[i]);
    		map.get(y[i]).add(x[i]);
    	}
    	
    	if (map.containsKey(1)) {
    		queue.add(1);
    	}
    	while (!queue.isEmpty()) {
    		int parent = queue.poll();
    		set.add(parent);
    		for (int child : map.get(parent)) {
    			if (!set.contains(child)) {
    				queue.add(child);
    				edges.put(child, parent);
    			}
    		}
    	}
    	
    	for (int i = 0; i < a.length; i++) {
    		if (edges.containsKey(a[i]) && edges.get(a[i]) == b[i]) {
    			ans[i] = 2;
    			continue;
    		}
    		if (edges.containsKey(b[i]) && edges.get(b[i]) == a[i]) {
    			ans[i] = 2;
    			continue;
    		}
    		if (edges.containsKey(a[i]) && edges.containsKey(b[i]) && edges.get(a[i]) == edges.get(b[i])) {    			
    			ans[i] = 1;
    			continue;
    		}
    		ans[i] = 0;
    	}
    	return ans;
    }
}
