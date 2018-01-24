package lintcode;

import java.util.Arrays;

public class TwoSumLessThanOrEqualToTarget {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > target && nums[i] > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] > target) {
                    break;
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }
}
