package lintcode;

public class ValidWordSquare {
	/**
     * @param words: a list of string
     * @return: a boolean
     */
    public boolean validWordSquare(String[] words) {
        // Write your code here
    	int height = words.length, width = words[0].length();
    	if (height != width) {
    		return false;
    	}
    	String[] rows = new String[height];
    	String[] cols = new String[width];
    	for (int i = 0; i < height; i++) {
    		rows[i] = words[i];
    	}
    	for (int i = 0; i < width; i++) {
    		StringBuilder col = new StringBuilder();
    		for (int j = 0; j < height; j++) {
    			col.append(words[i].charAt(j));
    		}
    		cols[i] = col.toString();
    	}
    	for (int i = 0; i < height; i++) {
    		if (!rows[i].equals(cols[i])) {
    			return false;
    		}
    	}
    	return true;
    }
}
