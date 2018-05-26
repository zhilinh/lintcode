package lintcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	/**
     * @param s: a string
     * @param t: a string
     * @return: true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
    	// HashMap will run out of time!!
    	// Create a specific character hashmap (ASCII 0-255)
    	int[] map = new int[256];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (map[sc[i]] == 0) {
                map[sc[i]] = tc[i];
            } else {
                if (map[sc[i]] != tc[i]) {
                    return false;
                }
            }
        }

        int[] map2 = new int[256];
        for (int i = 0; i < t.length(); i++) {
            if (map2[tc[i]] == 0) {
                map2[tc[i]] = sc[i];
            } else {
                if (map2[tc[i]] != sc[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
