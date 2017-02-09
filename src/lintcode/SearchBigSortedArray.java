package lintcode;

public class SearchBigSortedArray {
	/**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
    	int n = 0;
    	while (reader.get(n * n) != Integer.MAX_VALUE && reader.get((int) Math.pow(2, n)) <= target) {
    		n++;
    	}
    	n = (int) Math.pow(2, n);
    	int i = (n - 1) / 2;
    	int lidx, ridx;
    	if (n <= 0 || reader.get(0) == Integer.MAX_VALUE) { return -1; }
    	if (reader.get(i) >= target) {
    		lidx = 0;
    		ridx = i;
    	} else {
    		lidx = i;
    		ridx = n - 1;
    	}
    	while (ridx - lidx > 1) {
    		i = (lidx + ridx) / 2;
    		if (reader.get(i) < target) {
    			lidx = i;
    		}
    		if (reader.get(i) >= target) {
    			ridx = i;
    		}
    	}
    	if (reader.get(lidx) == target) {
    		return lidx;
    	} else if (reader.get(ridx) == target) {
    		return ridx;
    	} else {
    		return -1;
    	}
    }
}
