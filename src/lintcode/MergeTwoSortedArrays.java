package lintcode;

public class MergeTwoSortedArrays {
	/*
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
	public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
    	int n = A.length;
    	int m = B.length;
    	int pA = 0;
    	int pB = 0;
    	int pArr = 0;
    	int[] arr = new int[n + m];
    	while (pArr < n + m) {
    		if (pA >= n) {
    			arr[pArr] = B[pB];
    			pB++;
    		} else if (pB >= m) {
    			arr[pArr] = A[pA];
    			pA++;
    		} else if (A[pA] >= B[pB]) {
    			arr[pArr] = B[pB];
    			pB++;
    		} else if (A[pA] <= B[pB]) {
    			arr[pArr] = A[pA];
    			pA++;
    		}
    		pArr++;
    	}
    	return arr;
    }
}
