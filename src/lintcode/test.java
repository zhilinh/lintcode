package lintcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class test {

	public static void main(String[] args) {
	    WordLadder2 a = new WordLadder2();
	    Set<String> dict = new HashSet<String>();
	    dict.add("hit");
	    dict.add("cog");
	    dict.add("c");
	    System.out.println(a.findLadders("a", "c", dict));
	}
}
