package lintcode;

import java.util.List;

public class RecoverRotatedSortedArray {
	List<Integer> nums;
	
	private void reverseArray(int left, int right) {
		// i++, j--
		for (int i = left, j = right; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
	}
	
	public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
		if (nums == null || nums.size() == 0) {
			return;
		}
		this.nums = nums;
		for (int i = 0; i < nums.size() - 1; i++) {
			if (nums.get(i) > nums.get(i + 1)) {
				reverseArray(0, i);
				reverseArray(i + 1, nums.size() - 1);
				reverseArray(0, nums.size() - 1);
                return;
			}
		}
    }
}
