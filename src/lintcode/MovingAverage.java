package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	long sum, size;
	double count;
	Queue<Integer> queue;
	
	/*
	 * @param size: An integer
	 */public MovingAverage(int size) {
	     // do initialization if necessary
		 queue = new LinkedList<Integer>();
		 this.size = size;		 
		 sum = 0;
		 count = 0;
	 }

	 /*
	  * @param val: An integer
	  * @return:  
	  */
	 public double next(int val) {
	     // write your code here
		 queue.add(val);
		 if (count < size) {
			 count++;
			 sum += val;
		 } else {
			 int tmp = queue.poll();
			 sum -= tmp;
			 sum += val;
		 }
		 return sum / count;
	 }
}
