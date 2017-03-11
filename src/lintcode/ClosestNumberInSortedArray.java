package lintcode;

public class ClosestNumberInSortedArray {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int left = 0;
        int right = A.length - 1;
        int index = (left + right) / 2;
        while (left < right - 1) {
            if (A[index] > target) {
                right = index;
            } else if (A[index] < target) {
                left = index;
            } else {
                return index;
            }
            index = (left + right) / 2;
        }
        if (Math.abs(A[left] - target) > Math.abs(A[right] - target)) {
            return right;
        } else {
            return left;
        }
    }
}
