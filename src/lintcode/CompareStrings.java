package lintcode;

import java.util.HashMap;
import java.util.Map;

public class CompareStrings {
	/**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
    	Map<Character, Integer> aLetter = new HashMap<Character, Integer>();
    	Map<Character, Integer> bLetter = new HashMap<Character, Integer>();
    	for (char a : A.toCharArray()) {
    		if (aLetter.containsKey(a)) {
    			aLetter.put(a, aLetter.get(a) + 1);
    		} else {
    			aLetter.put(a, 1);
    		}
    	}
    	for (char b : B.toCharArray()) {
    		if (bLetter.containsKey(b)) {
    			bLetter.put(b, bLetter.get(b) + 1);
    		} else {
    			bLetter.put(b, 1);
    		}
    	}
    	for (char b : bLetter.keySet()) {
    		if (!aLetter.containsKey(b)) {
    			return false;
    		}
    		if (aLetter.get(b) < bLetter.get(b)) {
    			return false;
    		}
    	}
    	return true;
    }
}
