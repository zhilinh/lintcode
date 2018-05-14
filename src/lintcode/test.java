package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class test {

	public static void main(String[] args) {
		PreviousPermutation a = new PreviousPermutation();
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(1);
		System.out.println(a.previousPermuation(list));
	}
}
