package lintcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
	char[] ans = new char[4];
	char[] back = new char[4];
	int curr, diff = Integer.MAX_VALUE;
	int minDiff = Integer.MIN_VALUE;
	int midnight = 24 * 60;
	
	/**
     * @param time: the given time
     * @return: the next closest time
     */
    public String nextClosestTime(String time) {
        // write your code here
    	Set<Character> map = new HashSet<Character>();
    	String[] times = time.split(":");
    	int mins = Integer.valueOf(times[0]) * 60;
    	int secs = Integer.valueOf(times[1]);
    	curr = mins + secs;
    	
    	for (int i = 0; i < 2; i++) {
    		map.add(times[0].charAt(i));
    		map.add(times[1].charAt(i));
    	}
    	
    	dfs(0, map, new char[4]);
    	if (!map.contains(ans[0])) {
    		ans = back;
    	}
    	if (!map.contains(ans[0])) {
    		return time;
    	}
    	StringBuilder next = new StringBuilder();    	
    	next.append(ans[0]);
    	next.append(ans[1]);
    	next.append(':');
    	next.append(ans[2]);
    	next.append(ans[3]);
    	return next.toString();
    }
    
    public void dfs(int digit, Set<Character> dict, char[] comb) {
    	if (digit == 4) {
    		int mins = (comb[0] - '0') * 600 + (comb[1] - '0') * 60;
    		int sec = (comb[2] - '0') * 10 + (comb[3] - '0');
    		if (mins > 1380 || sec > 59) {
    			return;
    		}
    		
    		int sumTime = mins + sec;
    		if (sumTime > curr && sumTime - curr < diff) {
    			diff = sumTime - curr;
    			ans = Arrays.copyOf(comb, 4);
    		}
    		if (sumTime < curr && curr - sumTime > minDiff) {
    			minDiff = curr - sumTime;
    			back = Arrays.copyOf(comb, 4);
    		}
    		return;
    	}
    	for (char c : dict) {
    		comb[digit] = c;
    		dfs(digit + 1, dict, comb);
    	}    	
    }
}
