package lintcode;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
	/*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
    	StringBuilder enc = new StringBuilder();
    	for (String str : strs) {
    		enc.append(str);
    		enc.append("\n");
    	}
    	return enc.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
    	String[] enc = str.split("\n");
    	List<String> strs = new ArrayList<String>();
    	for (String s : enc) {
    		strs.add(s);
    	}
    	return strs;
    }
}
