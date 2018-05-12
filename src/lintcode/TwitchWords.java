package lintcode;

import java.util.ArrayList;
import java.util.List;

public class TwitchWords {
	/**
     * @param str: the origin string
     * @return: the start and end of every twitch words
     */
    public int[][] twitchWords(String str) {
        // Write your code here
    	if (str.length() == 0 || str == null) {
    		return new int[0][0];
    	}
    	List<int[]> tics = new ArrayList<int[]>();
    	int[][] ans;
    	char curr = str.charAt(0);
    	int count = 1;
    	int index = 0;
    	for (int i = 1; i < str.length();i++) {
    		if (str.charAt(i) == curr) {
    			count++;
    		} else {
    			if (count > 2) {
    				tics.add(new int[] {index, i - 1});
    			}
    			curr = str.charAt(i);
    			count = 1;
    			index = i;
    		}
    	}
    	if (count > 2) {
    		tics.add(new int[] {index, str.length() - 1});
    	}
    	ans = new int[tics.size()][2];
    	for (int i = 0; i < tics.size(); i++) {
    		ans[i] = tics.get(i);
    	}
    	return ans;
    }
}
