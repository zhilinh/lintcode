package lintcode;

import java.util.*;

public class WordLadder {
	
	class WordNode { 
		String val;
		int step;
		WordNode(String v, int s) {
			val = v;
			step = s;
		}
	}
	
	/*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
    	Queue<WordNode> queue = new LinkedList<WordNode>();
    	Set<String> path = new HashSet<String>();
    	path.add(start);
    	queue.add(new WordNode(start, 1));
    	while (!queue.isEmpty()) {
    		WordNode node = queue.poll();
    		if (calDis(end, node.val)) {
    			return node.step + 1;
    		}
    		Iterator<String> iter = dict.iterator();
    		while (iter.hasNext()) {
    			String curr = iter.next();
    			if (calDis(node.val, curr) && !path.contains(curr)) {
    				path.add(curr);
    				queue.add(new WordNode(curr, node.step + 1));
    			}
    		}
    	}
    	return 0;
    }
    
    private boolean calDis(String a, String b) {
    	char[] ac = a.toCharArray();
    	char[] bc = b.toCharArray();
    	int count = 0;
    	for (int i = 0; i < a.length(); i++) {
    		if (ac[i] != bc[i]) {
    			count++;
    		}
    	}
    	return count == 1;
    }
    
}
