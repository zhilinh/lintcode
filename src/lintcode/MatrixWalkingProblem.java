package lintcode;

import java.util.*;

public class MatrixWalkingProblem {
	
	class Grid {
		
		int x, y, step;
		boolean wall;
		Grid last;
		
		Grid(int x, int y, int step, boolean wall, Grid last) {
			this.x = x;
			this.y = y;
			this.step = step;
			this.wall = wall;
			this.last = last;
		}
	}	
	
	int[] xm = new int[] {-1, 1, 0, 0};
	int[] ym = new int[] {0, 0, -1, 1};	
	
	/**
     * @param grid: The gird
     * @return: Return the steps you need at least
     */
    public int getBestRoad(int[][] grid) {
        // Write your code here
    	if (grid == null || grid.length == 0) {
    		return -1;
    	}
    	
    	int height = grid.length;
    	int width = grid[0].length;
    	
    	Queue<Grid> queue = new LinkedList<Grid>();
    	Grid start = new Grid(0, 0, 0, true, null);
    	
    	queue.add(start);
    	
    	while (!queue.isEmpty()) {
    		Grid curr = queue.poll();
    		if (curr.x == height - 1 && curr.y == width - 1) {
    			return curr.step;
    		}
    		for (int i = 0; i < 4; i++) {
    			int x = curr.x + xm[i];
    			int y = curr.y + ym[i];
    			if (x < 0 || y < 0 || x >= height || y >= width) {
    				continue;
    			}
    			
    			if (curr.last != null && curr.last.x == x && curr.last.y == y) {
    				continue;
    			}
    			
    			if (grid[x][y] == 1) {
    				if (curr.wall) {
    					queue.add(new Grid(x, y, curr.step + 1, false, curr));
    				}
    			} else {
    				queue.add(new Grid(x, y, curr.step + 1, curr.wall, curr));
    			}
    		}
    	}
    	return -1;
    }
}
