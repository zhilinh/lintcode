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
		Deduplication a = new Deduplication();
		a.dedup("D:\\eclipse-workspace\\lintcode\\README-Copy.md", "D:\\eclipse-workspace\\lintcode\\test");
		a.redup("D:\\eclipse-workspace\\lintcode\\test", "D:\\eclipse-workspace\\lintcode\\OUTPUT.md");
	}
}
