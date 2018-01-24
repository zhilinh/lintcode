package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class test {

	public static void main(String[] args) {
		MergeTwoSortedArrays a = new MergeTwoSortedArrays();
		int[] A = {1,5};
		int[] B = {2,3};
		System.out.println(a.mergeSortedArray(A, B));
	}
}
