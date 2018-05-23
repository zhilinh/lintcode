package lintcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {
	Point origin;
	/**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
    	if (points == null || points.length == 0 || origin == null || k <= 0) {
    		return new Point[0];
    	}
    	Point[] ans = new Point[k];
    	if (k > points.length) {
    		k = points.length;
    	}
    	this.origin = origin;
    	Comparator<Point> comparator = new PointComparator(); 
    	PriorityQueue<Point> queue = new PriorityQueue<Point>(comparator);
    	for (int i = 0; i < points.length; i++) {
    		queue.add(points[i]);
    	}
    	for (int i = 0; i < k; i++) {
    		ans[i] = queue.poll();
    	}
    	return ans;
    }
    
    public class PointComparator implements Comparator<Point> {		

		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			double dis1 = Math.pow(o1.x - origin.x, 2) + Math.pow(o1.y - origin.y, 2);
			double dis2 = Math.pow(o2.x - origin.x, 2) + Math.pow(o2.y - origin.y, 2);
			if (dis1 > dis2) {
				return 1;
			}
			if (dis1 < dis2) {
				return -1;
			}
			if (Integer.compare(o1.x, o2.x) == 0) {
				return Integer.compare(o1.y, o2.y);
			} else {
				return Integer.compare(o1.x, o2.x);
			}
		}
    	
    }
}
