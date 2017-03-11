package lintcode;

public class SearchATwoDMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int leftRow = 0;
        int rightRow = matrix.length - 1;
        int index = (leftRow + rightRow) / 2;
        while (leftRow < rightRow - 1) {
            if (matrix[index][0] > target) {
                rightRow = index;
            } else if (matrix[index][0] < target) {
                leftRow = index;
            } else {
                return true;
            }
            index = (leftRow + rightRow) / 2;
        }
        int left = 0;
        int right = 0;
        if (matrix[rightRow][0] > target) {
            right = matrix[leftRow].length - 1;
            index = (left + right) / 2;
            while (left < right - 1) {
                if (matrix[leftRow][index] > target) {
                    right = index;
                } else if (matrix[rightRow - 1][index] < target) {
                    left = index;
                } else {
                    return true;
                }
                index = (left + right) / 2;
            }
            if (matrix[leftRow][left] == target || matrix[leftRow][right] == target) {
                return true;
            }
        } else {
            right = matrix[rightRow].length - 1;
            index = (left + right) / 2;
            while (left < right - 1) {
                if (matrix[leftRow][index] > target) {
                    right = index;
                } else if (matrix[leftRow][index] < target) {
                    left = index;
                } else {
                    return true;
                }
                index = (left + right) / 2;
            }
            if (matrix[rightRow][left] == target || matrix[rightRow][right] == target) {
                return true;
            }
        }
        return false;
    }
}