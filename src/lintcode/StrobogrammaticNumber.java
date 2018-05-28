package lintcode;

import java.util.*;

public class StrobogrammaticNumber {
	/**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        // write your code here
    	StringBuilder reverse = new StringBuilder();
    	Map<Character, Character> map = new HashMap<Character, Character>();
    	map.put('0', '0');
    	map.put('1', '1');
    	map.put('2', '*');
    	map.put('3', '*');
    	map.put('4', '*');
    	map.put('5', '*');
    	map.put('6', '9');
    	map.put('7', '*');
    	map.put('8', '8');
    	map.put('9', '6');
    	for (int i = num.length() - 1; i > -1; i--) {
    		reverse.append(map.get(num.charAt(i)));
    	}
    	return num.equals(reverse.toString());
    }
}
