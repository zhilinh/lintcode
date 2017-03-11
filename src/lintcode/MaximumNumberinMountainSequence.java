package lintcode;

public class MaximumNumberinMountainSequence {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = (left + right) / 2;
        while (left < right - 1) {
            if (nums[left] < nums[index]) {
                left = index;
            } else {
                right = index; 
            }
            index = (left + right) / 2;
            if (nums[right] < nums[index]) {
                right = index;
            } else {
                left = index; 
            }
            index = (left + right) / 2;
        }
        return Math.max(nums[left], nums[right]);
    }
}
