package lintcode;

public class ReverseWordsInAString {
	/*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
    	StringBuilder ans = new StringBuilder();
    	String str;
    	String[] words = s.split("\\s+");
    	for (int i = words.length - 1; i > -1; i--) {
    		ans.append(words[i] + " ");
    	}
    	str = ans.toString();
    	if (str.length() < 2) {
    		return "";
    	} else if (words.length < 2) {
    		return str.substring(0, str.length() - 1);
    	} else {
    		return str.substring(0, str.length() - 2);
    	}
    }
}
