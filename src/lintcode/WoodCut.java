package lintcode;

public class WoodCut {
	/**
	 * @param L: Given n pieces of wood with length L[i]
	 * @param k: An integer
	 * return: The maximum length of the small pieces.
	 */
	public int woodCut(int[] L, int k) {
		// write your code here
		int maxVal = 0;
		for (int i = 0; i < L.length; i++) {
			maxVal = Math.max(L[i], maxVal);
		}
		int start = 1;
		int end = maxVal;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (count(L, mid) >= k) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (count(L, end) >= k) {
			return end;
		}
		if (count(L, start) >= k) {
			return start;
		}
		return 0;
	}
	
	private int count(int[] L, int length) {
		int sum = 0;
		for (int i = 0; i < L.length; i++) {
			sum += L[i] / length;
		}
		return sum;
	}
}
