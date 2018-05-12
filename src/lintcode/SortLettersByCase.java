package lintcode;

public class SortLettersByCase {
	/*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
    	// Index of an earliest upper case letter
    	int currCap = -1;
    	for (int i = 0; i < chars.length; i++) {
    		// If chars[i] is an upper case letter
    		if (chars[i] < 'a') {
    			// Update currCap if no capital letter appeared
    			currCap = currCap == -1 ? i : currCap;
    		// If there is a capital letter before chars[i]
    		} else if (currCap != -1) {
    			// Swap
    			char tmp = chars[i];
    			chars[i] = chars[currCap];
    			chars[currCap] = tmp;
    			
    			// Update currCap after swap by checking the next letter
    			if (chars[currCap + 1] < 'a') {
    				currCap++;    				
    			} else {
    				currCap = i;
    			}
    		}
    	}
    }
}
