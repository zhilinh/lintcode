package lintcode;

import java.util.*;

public class FindAllAnagramsInAString {
	/**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // write your code here
    	List<Integer> ans = new ArrayList<Integer>();
    	if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
    		return ans;
    	}    	
    	int[] cntP = new int[256];
    	char[] sc = s.toCharArray();
    	char[] pc = p.toCharArray();
    	for (int i = 0; i < pc.length; i++) {
    		cntP[pc[i]]++;
    	}
    	
    	isAnagram(cntP, s.substring(0, pc.length));
    	if (checkCounts(cntP)) {
			ans.add(0);
		}
    	for (int i = 0; i < sc.length - pc.length; i++) {
    		cntP[sc[i]]++;
    		cntP[sc[i + pc.length]]--;
    		if (checkCounts(cntP)) {
    			ans.add(i + 1);
    		}
    	}
    	
    	return ans;
    }
    
    public void isAnagram(int[] cntP, String s) {
    	char[] sc = s.toCharArray();
    	for (int i = 0; i < sc.length; i++) {
    		cntP[sc[i]]--;
    	}
    }
    
    public boolean checkCounts(int[] cntP) {
    	for (int i = 0; i < 256; i++) {
    		if (cntP[i] != 0) {
    			return false;
    		}
    	}
    	return true;
    }
}
