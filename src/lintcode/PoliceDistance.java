package lintcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PoliceDistance {
	int[][] direction = new int[][] {
		{-1, 1, 0, 0},
		{0, 0, -1, 1},		
	};
	
	private class Index {
        public int x, y, step;
        public Index(int x, int y, int step) {
            this.x = x;
            this.y = y;
            // Cannot find a better way to record steps!
            this.step = step;
        }
    }
	
	/**
     * @param matrix : the martix
     * @return: the distance of grid to the police
     */
    public int[][] policeDistance(int[][] matrix) {
        // Write your code here
    	int height = matrix.length;
    	int width = matrix[0].length;
    	int[][] ans = new int[height][width];
    	
    	for (int i = 0; i < height; i++) {
    		for (int j = 0; j < width; j++) {    			
    			Queue<Index> bfsList = new LinkedList<Index>();
    			Map<int[], Boolean> trace = new HashMap<int[], Boolean>();
    			if (matrix[i][j] == -1) {
    				ans[i][j] = -1;
    				continue;
    			} else if (matrix[i][j] == 1) {
    				ans[i][j] = 0;
    				continue;
    			}
    			bfsList.add(new Index(i, j, 0));
    			
    			while (!bfsList.isEmpty()) {
    				Index pos = bfsList.poll();
    				trace.put(new int[] {pos.x, pos.y}, true);
    				if (pos.x < 0 || pos.x >= height) {
    					continue;
    				}
    				if (pos.y < 0 || pos.y >= width) {
    					continue;
    				}
    				if (matrix[pos.x][pos.y] == 1) {
    					ans[i][j] = pos.step;
    					break;
    				} else if (matrix[pos.x][pos.y] == 0) {
    					for (int k = 0; k < 4; k++) {
    						int nextX = pos.x + direction[0][k];
    						int nextY = pos.y + direction[1][k];
    						// Trim BFS Tree
    						if (!trace.containsKey(new int[] {nextX, nextY})) {
    							Index next = new Index(nextX, nextY, pos.step + 1);
    							bfsList.add(next);
    						}
    					}
    				}
    			}
    		}
    	}
    	return ans;
    }
}
