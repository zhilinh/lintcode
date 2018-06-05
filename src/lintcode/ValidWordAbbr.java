package lintcode;

import java.util.*;

public class ValidWordAbbr {
	
	Map<String, Integer> map, cnt;
	/*
	 * @param dictionary: a list of words
	 */
	public ValidWordAbbr(String[] dictionary) {
		// do initialization if necessary
		map = new HashMap<String, Integer>();
		cnt = new HashMap<String, Integer>();
		for (String s : dictionary) {
			if (s.length() > 2) {
				String k = s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
				if (map.containsKey(k)) {
					map.put(k, map.get(k) + 1);
				} else {
					map.put(k, 1);
				}
			}
			
			if (cnt.containsKey(s)) {
				cnt.put(s, cnt.get(s) + 1);
			} else {
				cnt.put(s, 1);
			}
		}
	}

	/*
	 * @param word: a string
	 * @return: true if its abbreviation is unique or false
	 */
	public boolean isUnique(String word) {
		// write your code here
		if (word.length() < 3) {
			return true;
		}
		String k = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
		
		if (!cnt.containsKey(word) && map.containsKey(k)) {
			return false;
		}
		
		if (map.get(k) == cnt.get(word)) {
			return true;
		}
		return false;
	}
}
