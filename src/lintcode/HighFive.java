package lintcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {
	
	class Record {
		public int id, score;
		public Record(int id, int score) {
			this.id = id;
			this.score = score;
		}
	}	
	
	public class Solution {
	    /**
	     * @param results a list of <student_id, score>
	     * @return find the average of 5 highest scores for each person
	     * Map<Integer, Double> (student_id, average_score)
	     */
	    public Map<Integer, Double> highFive(Record[] results) {
	        // Write your code here
	    	Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
	    	Map<Integer, Double> ans = new HashMap<Integer, Double>();
	    	for (Record r : results) {
	    		if (!map.containsKey(r.id)) {
	    			// Collections.reverseOrder()
	    			map.put(r.id, new PriorityQueue<Integer>(Collections.reverseOrder()));
	    		}
	    		PriorityQueue<Integer> queue = map.get(r.id);
	    		queue.add(r.score);
	    	}
	    	for (Integer i : map.keySet()) {
	    		Double ave = 0.0;
	    		PriorityQueue<Integer> queue = map.get(i);
	    		for (int j = 0; j < 5; j++) {
	    			ave += queue.poll();
	    		}	    		
	    		ans.put(i, ave / 5);
	    	}	    	
	    	return ans;
	    }
	}

}
