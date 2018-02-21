package lintcode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DicesSum {
	/**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
    	List<Map.Entry<Integer, Double>> ans = new ArrayList<Map.Entry<Integer, Double>>();
    	Map<Integer, Double> map = new HashMap<Integer, Double>();
    	map.put(0, 1.0);
    	for (int i = 0; i < n; i++) {
    		Map<Integer, Double> tmp = new HashMap<Integer, Double>();
    		for (int j = i + 1; j < 6 * (i + 1) + 1; j++) {
    			double sum = 0;
    			for (int k = 1; k < 7; k++) {
    				if (map.containsKey(j - k)) {
    					sum += map.get(j - k) * (1.0 / 6);
    				}
        		}
    			tmp.put(j, sum);
    		}
    		map = tmp;
    	}
    	ans.addAll(map.entrySet());
    	return ans;
    }    
}
