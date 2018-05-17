package lintcode;

public class StringToInteger {
	/**
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        // write your code here
    	String[] digits = str.split(".");
    	StringBuilder tmp = new StringBuilder();
    	long ans = 0;
    	int sign = 0, start = 0;
    	if (digits.length > 2) {
    		return 0;
    	}
    	if (digits.length == 2) {
    		str = digits[0];
    	}
    	str = str.replaceAll("\\s+", "");
    	if (str.length() == 0) {
    		return 0;
    	}
    	
    	if (str.charAt(start) < '0' || str.charAt(start) > '9') {
    		if (str.charAt(start) == '+' || str.charAt(start) == '-') {
    			sign = str.charAt(start) == '+' ? 1 : -1;
    			start++;
    		} else {
    			return 0;
    		}
    	} else {
    		sign = 1;
    	}
    	
    	for (int i = start; i < str.length(); i++) {
    		if (str.charAt(i) > '9' || str.charAt(i) < '0') {
    			break;
    		}
    		tmp.append(str.charAt(i));
    	}
    	
    	try {
    		ans = Long.parseLong(tmp.toString());
    		ans *= sign;
    	} catch (Exception e) {
    		if (tmp.length() == 0) {
    			return 0;
    		}
    		return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    	}

    	if (ans > 2147483647) {
    		return Integer.MAX_VALUE;
    	}
    	if (ans < -2147483648) {
    		return Integer.MIN_VALUE;
    	}
    	return (int) ans;
    }
}
