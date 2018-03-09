package lintcode;

public class SearchATwoDMatrixII {
	/**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
    	// write your code here
        /** O(mn)
        int occur = 0;        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] >= target) {
                    if (matrix[i][j] == target) {
                        occur++;
                    }
                    break;
                }
            }
        }
        return occur;
        **/
        
        // O(m + n)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int r = matrix.length - 1;
        int c = 0;
        int occur = 0;
        while (r >= 0 && c < matrix[0].length) {
            if (matrix[r][c] == target) {
                occur++;
                r--;
                c++;
                continue;
            }
            if (target > matrix[r][c]) {
                c++;
            } else {
                r--;
            }
        }
        return occur;        
    }
}
