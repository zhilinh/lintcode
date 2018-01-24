package lintcode;

import java.util.HashMap;
import java.util.Map;

public class StrStr2 {
	/*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    public int strStr2(String source, String target) {
    	if (source == null || target == null || source.length() < target.length()) {
    		return -1;
    	}
    	
    	// int mod = Integer.MAX_VALUE / 31;
    	int mod = 1000000;
    	
    	int targetLength = target.length();
    	if (targetLength == 0) {
    		return 0;
    	}
    	
    	int greatestPower = 1;
    	int sourceCode = 0;
    	int targetCode = 0;
    	for (int i = 0; i < targetLength; i++) {
    		greatestPower = (greatestPower * 31) % mod;
    		targetCode = (targetCode * 31 + target.charAt(i)) % mod; 
    	}
    	
    	for (int i = 0; i < source.length(); i++) {
    		sourceCode = (sourceCode * 31 + source.charAt(i)) % mod;
    		if (i < targetLength - 1) {
    			continue;
    		}
    		
    		if (i >= targetLength) {
    			sourceCode = sourceCode - (source.charAt(i - targetLength) * greatestPower) % mod;
    			if (sourceCode < 0) {
    				sourceCode += mod;
    			}
    		}
    		
    		if (sourceCode == targetCode && source.substring(i - targetLength + 1, i + 1).equals(target)) {
    			return i - targetLength + 1;
    		}
    	}
    	return -1;
    }
}
