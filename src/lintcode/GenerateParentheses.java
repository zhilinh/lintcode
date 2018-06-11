package lintcode;

import java.util.*;

public class GenerateParentheses {
	
	List<String> ans;
	
	/**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        // write your code here
    	ans = new ArrayList<String>();
    	parenthesisQueue(n, 0, new StringBuilder());
    	return ans;
    }
    
    private void parenthesisQueue(int n, int endP, StringBuilder curr) {
    	if (n == 0 && endP == 0) {
    		if (curr.length() != 0) {
    			ans.add(curr.toString());
    		}
    		return;
    	}
    	StringBuilder tmp = new StringBuilder(curr);
    	if (n > 0) {
    		tmp.append('(');
    		parenthesisQueue(n - 1, endP + 1, tmp);
    	}
    	tmp = new StringBuilder(curr);
    	if (endP > 0) {
    		tmp.append(')');
    		parenthesisQueue(n, endP - 1, tmp);
    	}
    }
}
