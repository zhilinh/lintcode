package lintcode;

public class PlusOne {
	/**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here
        int carries = 1;
        // Fast break when carries equal to ZERO!
        for (int i = digits.length - 1; i > -1 && carries > 0; i--) {
            int digit = digits[i] + carries;
            if (digit > 9) {
                digits[i] = digit - 10;
            } else {
                digits[i] = digit;
                carries = 0;
            }
        }
        if (carries == 1) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            for (int i = 1; i < ans.length; i++) {
                ans[i] = digits[i - 1];
            }
            return ans;
        } else {
            return digits;
        }
    }
}
