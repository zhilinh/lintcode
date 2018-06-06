package lintcode;

import java.util.*;

public class FlipGame {
	/**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
    	Set<String> ans = new HashSet<String>();
    	if (s.length() < 2) {
    		return new ArrayList<String>(ans);
    	}
    	int i = 0;
    	while (i < s.length() - 1) {
    		StringBuilder tmp = new StringBuilder();
    		// "++" ONLY!
    		if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {
    			tmp.append(s.substring(0, i));
    			tmp.append("--");
    			tmp.append(s.substring(i + 2, s.length()));
    			ans.add(tmp.toString());
    		}
    		// Could be "-++"
    		i++;
    	}
    	return new ArrayList<String>(ans);
    }
}
