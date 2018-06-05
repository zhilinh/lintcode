package lintcode;

public class ValidAnagram {
	/**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
    	int[] hashmap = new int[256];
    	char[] sc = s.toCharArray();
    	char[] tc = t.toCharArray();
    	for (int i = 0; i < sc.length; i++) {
    		hashmap[sc[i]]++;
    	}
    	for (int i = 0; i < tc.length; i++) {
    		hashmap[tc[i]]--;
    	}
    	for (int i = 0; i < 256; i++) {
    		if (hashmap[i] != 0) {
    			return false;
    		}
    	}
    	return true;
    }
}
