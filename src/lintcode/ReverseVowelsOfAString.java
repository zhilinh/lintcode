package lintcode;

import java.util.*;

public class ReverseVowelsOfAString {
	/**
     * @param s: a string
     * @return: reverse only the vowels of a string
     */
    public String reverseVowels(String s) {
        // write your code here
    	Set<Character> vowels = new HashSet<Character>();
    	vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');vowels.add('u');
    	vowels.add('A');vowels.add('E');vowels.add('I');vowels.add('O');vowels.add('U');
    	char[] sc = s.toCharArray();
    	StringBuilder vs = new StringBuilder();
    	StringBuilder ans = new StringBuilder();
    	for (int i = sc.length - 1; i > -1; i--) {
    		if (vowels.contains(sc[i])) {
    			vs.append(sc[i]);
    		}
    	}
    	int count = 0;
    	for (int i = 0; i < sc.length; i++) {
    		if (vowels.contains(sc[i])) {
    			ans.append(vs.charAt(count));
    			count++;
    		} else {
    			ans.append(sc[i]);
    		}
    	}
    	return ans.toString();
    }
}
