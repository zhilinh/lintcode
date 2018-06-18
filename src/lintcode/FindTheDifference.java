package lintcode;

public class FindTheDifference {
	/**
     * @param s: a string
     * @param t: a string
     * @return: the letter that was added in t
     */
    public char findTheDifference(String s, String t) {
        // Write your code here
    	int[] dict = new int[256];
    	char[] sc = s.toCharArray();
    	char[] tc = t.toCharArray();
    	for (int i = 0; i < sc.length; i++) {
    		dict[sc[i]]++;
    	}
    	for (int i = 0; i < tc.length; i++) {
    		dict[tc[i]]--;
    	}
    	for (int i = 0; i < tc.length; i++) {
    		if (dict[tc[i]] == -1) {
    			return tc[i];
    		}
    	}
    	return '0';
    }
}
