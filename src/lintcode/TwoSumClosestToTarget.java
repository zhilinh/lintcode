package lintcode;

import java.util.Arrays;

public class TwoSumClosestToTarget {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length <= 2) {
            return target;
        }
        Arrays.sort(nums);
        int dis = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            right = nums.length - 1; 
            while (left < right && nums[left] + nums[right] > target) {
                dis = Math.min(dis, nums[left] + nums[right] - target);
                right--;
            }
            if (left < right) {
                dis = Math.min(dis, target - nums[left] - nums[right]);
            }
            left++;
        }
        return dis;
    }
}
