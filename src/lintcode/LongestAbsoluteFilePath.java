package lintcode;

import java.util.*;

public class LongestAbsoluteFilePath {
	
	/*
     * @param input an abstract file system
     * @return return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        // Write your code here
        if (input.length() == 0) {
            return 0;
        }
        int ans = 0;
        int[] sum = new int[input.length() + 1];

        for (String line : input.split("\n")) {
            int level = line.lastIndexOf('\t') + 2;
            int len = line.length() - (level - 1);
            if (line.contains(".")) {
                ans = Math.max(ans, sum[level - 1] + len);
            } else {
                sum[level] = sum[level - 1] + len + 1;
            }
        }
        return ans;
    }
    
//	/**
//     * @param input: an abstract file system
//     * @return: return the length of the longest absolute path to file
//     */
//    public int lengthLongestPath(String input) {
//        // write your code here
//    	String[] inputArray = input.split("\n");
//    	Stack<Integer> len = new Stack<Integer>();
//    	int lastLevel = 0, maxLen = 0;
//    	for (String s : inputArray) {
//    		int level = 0;
//    		while (s.contains("\t")) {
//    			s = s.replaceFirst("\t", "");
//    			level++;
//    		}
//    		if (level <= lastLevel) {
//    			maxLen = compareLen(len, maxLen, level, s);
//    			for (int i = 0; i < lastLevel - level + 1 && !len.isEmpty(); i++) {
//        			len.pop();
//        		}
//    		}
//    		lastLevel = level;
//    		len.push(s.length());
//    	}
//    	maxLen = compareLen(len, maxLen, lastLevel, inputArray[inputArray.length - 1]);
//    	return maxLen;
//    }
//    
//    public int compareLen(Stack<Integer> len, int maxLen, int level, String fileName) {
//    	if (!fileName.contains(".")) {
//    		return maxLen;
//    	}
//    	int currLen = level;
//		Iterator<Integer> iter = len.iterator();
//		while (iter.hasNext()) {
//			currLen += iter.next();
//		}
//		return Math.max(currLen, maxLen);
//    }
}
