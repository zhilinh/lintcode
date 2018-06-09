package lintcode;

public class FirstPositionUniqueCharacter {
	/**
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        // write your code here
    	char[] map = new char[256];
    	char[] sc = s.toCharArray();
    	for (int i = 0; i < sc.length; i++) {
    		map[sc[i]]++;
    	}    	
    	for (int i = 0; i < sc.length; i++) {
    		if (map[sc[i]] == 1) {
    			return i;
    		}
    	}
    	return -1;
    }
}
