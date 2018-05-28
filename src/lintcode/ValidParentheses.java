package lintcode;

import java.util.*;

public class ValidParentheses {
	/**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
    	Stack<Character> stack = new Stack<Character>();
    	Map<Character, Character> map = new HashMap<Character, Character>();
    	map.put('{', '}');
    	map.put('[', ']');
    	map.put('(', ')');
    	for (int i = 0; i < s.length(); i++) {
    		if (map.containsKey(s.charAt(i))) {
    			stack.push(map.get(s.charAt(i)));
    			continue;
    		}
    		if (stack.empty() || s.charAt(i) != stack.pop()) {
    			return false;
    		}
    	}
    	return stack.isEmpty();
    }
}
