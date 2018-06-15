package lintcode;

public class SentenceScreenFitting {
	/**
     * @param sentence: a list of string
     * @param rows: an integer
     * @param cols: an integer
     * @return: return an integer, denote times the given sentence can be fitted on the screen
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // Write your code here
    	int count = 0, wordIndex = 0;
    	for (int i = 0; i < rows; i++) {
    		int spaceLeft = cols;
    		while (spaceLeft - sentence[wordIndex].length() - 1 >= 0) {
    			spaceLeft -= sentence[wordIndex].length() + 1;
    			wordIndex++;
    			if (wordIndex == sentence.length) {
    				count++;
    				wordIndex = 0;
    			}
    		}
    		if (spaceLeft - sentence[wordIndex].length() == 0) {
    			wordIndex++;
    			if (wordIndex == sentence.length) {
    				count++;
    				wordIndex = 0;
    			}
    		}
    	}
    	return count;
    }
}
