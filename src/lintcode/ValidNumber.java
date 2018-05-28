package lintcode;

public class ValidNumber {
	/**
     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // write your code here
    	int init = 0, i;
    	boolean dot = false;
    	boolean e = false;
    	if (s == null || s.length() == 0) {
    		return false;
    	}
    	
    	char[] array = s.toCharArray();
    	while (init < array.length && array[init] == ' ') {
    		init++;
    	}
    	if (init >= array.length || array[init] == 'e') {
    		return false;
    	}
    	if (array[init] == '-' || array[init] == '+') {
    		init++;
    	}
    	if (array[init] == '.' && (init == array.length - 1 || !Character.isDigit(array[init + 1]))) {
    		return false;
    	}
    	i = init;
    	while (i < array.length) {
    		if (Character.isDigit(array[i])) {
    			i++;
    			continue;
    		}
    		
    		if (array[i] == '.') {
    			if (dot || e) {
    				return false;
    			}
    			dot = true;
    			i++;
    			continue;
    		}
    		
    		if (array[i] == 'e') {
    			if (e || i == array.length - 1) {
    				return false;
    			}
    			e = true;
    			if (Character.isDigit(array[i + 1])) {
    				i++;
    				continue;
    			}
    			if (array[i + 1] != '+' && array[i + 1] != '-') {
    				return false;
    			}
    			if (i + 1 == array.length - 1) {
    				return false;
    			}
    			i += 2;
    			continue;
    		}
    		
    		if (array[i] == ' ') {
    			i++;
    			break;
    		}
    		return false;
    	}
    	
    	for (int j = i; j < array.length; j++) {
    		if (array[j] != ' ') {
    			return false;
    		}
    	}
    	return true;
    }
}
