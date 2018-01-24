package lintcode;

public class MedianOfTwoSortedArrays {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {        
        // write your code here
        int m = A.length;
        int n = B.length;
        int index1 = 0;
        int index2 = 0;
        if ((m + n) % 2 == 0) {
            if (m == 1 && n == 1) {
                return (A[0] + B[0]) / 2.0;
            }
            index1 = (m + n) / 2 - 1;
            index2 = index1 + 1;
        } else {
            index1 = (m + n) / 2;
            index2 = index1;
        }
        int[] merged = new int[m + n];
        int index = 0;
        int indexA = 0;
        int indexB = 0;
        while (indexA < m && indexB < n) {
            if (index == index2 + 1) {
                return (merged[index1] + merged[index2]) / 2.0; 
            } else {
                if (A[indexA] < B[indexB]) {
                    merged[index] = A[indexA];
                    indexA++;                    
                } else {
                    merged[index] = B[indexB];
                    indexB++;                    
                }
                index++;
            }
        }        
        while (indexA < m) {
            if (index == index2 + 1) {
                return (merged[index1] + merged[index2]) / 2.0;
            } else {
                merged[index] = A[indexA];
                indexA++;
                index++;
            }
        }
        while (indexB < n) {
            if (index == index2 + 1) {
                return (merged[index1] + merged[index2]) / 2.0;
            } else {
                merged[index] = B[indexB];
                indexB++;
                index++;
            }
        }
        if (index == index2 + 1) {
            return (merged[index1] + merged[index2]) / 2.0;
        }
        return 0.0;
    }
}
