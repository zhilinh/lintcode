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
		EvaluateReversePolishNotation a = new EvaluateReversePolishNotation();
		System.out.println(a.evalRPN(new String[]{"3", "-4", "+"}));
	}
}
