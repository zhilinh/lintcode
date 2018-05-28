package lintcode;

import java.util.*;

public class FindAnagramMappings {
	/**
     * @param A: lists A
     * @param B: lists B
     * @return: the index mapping
     */
    public int[] anagramMappings(int[] A, int[] B) {
        // Write your code here
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] indices = new int[A.length];
    	for (int i = 0; i < B.length; i++) {
    		map.put(B[i], i);
    	}
    	for (int i = 0; i < A.length; i++) {
    		indices[i] = map.get(A[i]);
    	}
    	return indices;
    }
}
