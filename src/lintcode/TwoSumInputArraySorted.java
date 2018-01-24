package lintcode;

public class TwoSumInputArraySorted {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] ans = new int[]{0,0};
        if (nums == null || nums.length == 0) {
            return ans;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (target < 2 * nums[i]) {
                return ans;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return ans;
    }
}
