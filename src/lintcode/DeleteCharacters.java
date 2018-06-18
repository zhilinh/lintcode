package lintcode;

public class DeleteCharacters {
	/**
     * @param s: The string s
     * @param t: The string t
     * @return: Return if can get the string t
     */
    public boolean canGetString(String s, String t) {
        // Write your code here
        if (s.length() < t.length()) {
            return false;
        }
        
        int sp = 0, tp = 0;
        while (sp < s.length()) {
        	if (s.charAt(sp) == t.charAt(tp)) {
        		tp++;
        		if (tp == t.length()) {
        			return true;
        		}
        	}
        	sp++;
        }
        
        return false;
        
//        DP:
//        int[][] opt = new int[s.length() + 1][t.length() + 1];
//        for (int i = 1; i < s.length() + 1; i++) {
//        	for (int j = 1; j < t.length() + 1; j++) {
//        		if (s.charAt(i - 1) == t.charAt(j - 1)) {
//        			opt[i][j] = Math.max(opt[i - 1][j - 1] + 1, opt[i][j]);
//        		} else {
//        			opt[i][j] = Math.max(opt[i - 1][j], opt[i][j - 1]);
//        		}
//        	}
//        }
//        return opt[s.length()][t.length()] == t.length();
    }
    
//    public void deleteCharacters(String s, String t) {
//    	if (s.length() == t.length()) {
//    		ans = s.equals(t) ? true : ans;
//    		return;
//    	}
//    	for (int i = 0; i < s.length(); i++) {
//    		StringBuilder tmp = new StringBuilder();
//    		tmp.append(s.substring(0, i));
//    		tmp.append(s.substring(i + 1, s.length()));
//    		deleteCharacters(tmp.toString(), t);
//    	}
//    }
}
