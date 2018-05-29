package lintcode;

import java.util.*;

public class EvaluateReversePolishNotation {
	/**
     * @param tokens: The Reverse Polish Notation
     * @return: the value
     */
    public int evalRPN(String[] tokens) {
        // write your code here
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < tokens.length; i++) {
    		try {
    			stack.push(Integer.parseInt(tokens[i]));
    		} catch (Exception e) {
    			int first = stack.pop();
    			int second = stack.pop();
    			switch (tokens[i].charAt(0)) {
    			case '+':
    				second += first;
    				break;
    			case '-':
    				second -= first;
    				break;
    			case '*':
    				second *= first;
    				break;
    			case '/':
    				second /= first;
    				break;
    			}
    			stack.push(second);
    		}
    	}
    	return stack.pop();
    }
}
