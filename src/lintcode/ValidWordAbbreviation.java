package lintcode;

public class ValidWordAbbreviation {
	/**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here    	
    	int wp = 0, val = 0;
    	char[] wc = word.toCharArray();
    	char[] ac = abbr.toCharArray();
    	for (int i = 0; i < ac.length; i++) {
    		if ('0' <= ac[i] && ac[i] <= '9') {
    			if (val == 0 && ac[i] == '0') {
    				return false;
    			}
    			val = val * 10 + ac[i] - '0';    			
    		} else {
    			wp += val;
    			val = 0;
    			if (wc[wp] != ac[i]) {
    				return false;
    			}
    			wp++;
    		}
    	}
    	return wp + val == wc.length;
    }
}
