package lintcode;

public class OneEditDistance {
	/**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
    	int edit = 0;
    	if (s == null || t == null) {
    		return false;
    	}
    	if (s.length() == t.length()) {
    		for (int i = 0; i < s.length(); i++) {
        		if (s.charAt(i) != t.charAt(i)) {
        			edit++;
        		}
        	}
        	return edit == 1;
    	}
    	if (Math.abs(s.length() - t.length()) == 1) {
    		int sp = 0, tp = 0;
    		while (sp < s.length() && tp < t.length()) {
    			if (s.charAt(sp) != t.charAt(tp)) {
    				edit++;
    				if (s.length() < t.length()) {
    					tp++;
    				} else {
    					sp++;
    				}
    			} else {
    				sp++;
    				tp++;
    			}
    		}
    		return edit <= 1;
    	}
    	return false;
    }
}
