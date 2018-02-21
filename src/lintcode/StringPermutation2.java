package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutation2 {
	Set<String> strSet = new HashSet<String>();
    /*
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here    	
    	List<String> result = new ArrayList<String>();
    	result.add("");
    	if (str == null || str.length() == 0) {
    		return result;
    	}
    	permutate(str, result);
    	result.remove(0);
    	result.addAll(strSet);
    	Collections.sort(result);
    	return result;
    }
    
    public void permutate(String str, List<String> array) {
    	if (str.length() == 1) {
    		for (int i = 0; i < array.size(); i++) {
    			String tmp = array.get(i);
    		    array.set(i, tmp + str);
    		}
    		strSet.addAll(array);
    	} else {
    		for (int i = 0; i < str.length(); i++) {
    			for (int j = 0; j < array.size(); j++) {
    				String tmp = array.get(j);
    				array.set(j, tmp + String.valueOf(str.charAt(i)));
    				permutate(str.substring(0, i) + str.substring(i + 1, str.length()), array);
    				array.set(j, tmp);
    			}
    		}
    	}
    }
}
