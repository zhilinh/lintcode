package lintcode;

public class ToeplitzMatrix {
	/**
     * @param matrix: the given matrix
     * @return: True if and only if the matrix is Toeplitz
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // Write your code here
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return false;
    	}
    	int height = matrix.length, width = matrix[0].length;
    	for (int i = 0; i < matrix[0].length; i++) {
    		int x = 0, y = i, init = matrix[x][y];
    		while (x < height && y < width) {
    			if (matrix[x][y] == init) {
    				x++;
    				y++;
    			} else {
    				return false;
    			}
    		}
    	}
    	for (int i = 1; i < matrix.length; i++) {
    		int x = i, y = 0, init = matrix[x][y];
    		while (x < height && y < width) {
    			if (matrix[x][y] == init) {
    				x++;
    				y++;
    			} else {
    				return false;
    			}
    		}    		
    	}
    	return true;
    }
}
