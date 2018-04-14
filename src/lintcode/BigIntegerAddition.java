package lintcode;

public class BigIntegerAddition {
	/**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // write your code here
    	int and1 = 0;
    	StringBuilder ans = new StringBuilder();
    	int i = num1.length(), j = num2.length();
    	while (i >= 0 || j >= 0) {
    		int tmp1 = 0, tmp2 = 0, sum = 0;
    		i--;
    		j--;
    		if (i >= 0) {
    			tmp1 = num1.charAt(i) - '0';
    		} else {
    			tmp1 = 0;
    		}
    		if (j >= 0) {
    			tmp2 = num2.charAt(j) - '0';
    		} else {
    			tmp2 = 0;
    		}
    		sum = tmp1 + tmp2 + and1;
    		if (sum >= 10) {
    			and1 = 1;
    			sum -= 10;
    		} else {
    			and1 = 0;
    		}
    		ans.insert(0, String.valueOf(sum));
    	}    	
    	while (ans.charAt(0) == '0' && ans.length() > 1) {
    		ans.deleteCharAt(0);
    	}
    	return ans.toString();
    }
}
