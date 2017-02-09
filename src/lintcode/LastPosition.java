package lintcode;

public class LastPosition {
	public int lastPosition(int[] nums, int target) {
		int n = nums.length;
		int i = (n - 1) / 2;
		int lidx, ridx;
		if (n == 0 || nums == null) { return -1; }
		if (nums[i] > target) {
			lidx = 0;
			ridx = i;
		} else {
			lidx = i;
			ridx = n - 1;
		}
		while (ridx - lidx > 1) {
			i = (lidx + ridx) / 2;
			if (nums[i] <= target) {
				lidx = i;
			}
			if (nums[i] > target) {
				ridx = i;
			}
		}
		if (nums[ridx] == target) {
			return ridx;
		} else if (nums[lidx] == target) {
			return lidx;
		} else {
			return -1;
		}
    }
}
