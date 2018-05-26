package lintcode;

public class DecodeWays {
	/**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
    	if (s == null || s.length() == 0 || s.charAt(0) == '0') {
    		// if it starts with '0' all is invalid
    		return 0;
    	}
    	int[] opt = new int[s.length()];
    	opt[0] = 1;
    	for (int i = 1; i < s.length(); i++) {
    		int tmp = 0;
    		int val = Integer.parseInt(s.substring(i - 1, i + 1));
    		// Two digits must be between 10 and 26
    		if (val < 27 && val > 9) {
    			tmp = i - 2 > -1 ? opt[i - 2] : 1;
    		}
    		// One digit one letter is impossible because of '0'
    		if (s.charAt(i) != '0') {
    			opt[i] = opt[i - 1] + tmp;
    		} else {
    			opt[i] = tmp;
    		}    		
    	}
    	return opt[s.length() - 1];
    }
}
