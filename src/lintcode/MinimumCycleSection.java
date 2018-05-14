package lintcode;

public class MinimumCycleSection {
	/**
     * @param array: an integer array
     * @return: the length of the minimum cycle section
     */
    public int minimumCycleSection(int[] array) {
        // Write your code here
    	// KMP
    	int[] next = new int[array.length + 1];
    	int j = -1, i = 0;
    	next[0] = -1;
    	while (i < array.length) {
    		// Update the index at i to the left index j
    		if (j == -1 || array[j] == array[i]) {
    			i++;
    			j++;
    			next[i] = j;
    		// Remain the left index as the index at j
    		} else {
    			j = next[j];
    		}
    	}
    	// Length - Non Cycle Section
    	// (i - 1) - (next[i] - 1) = i - next[i]
    	return i - next[i];
    }
}
