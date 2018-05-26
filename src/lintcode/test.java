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
		ResidualProduct a = new ResidualProduct();
		int[] ans = a.getProduct(new int[] {10,10,10,10,10,10,10,10,10,10});
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}		
	}
}
