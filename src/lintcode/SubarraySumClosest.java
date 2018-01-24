package lintcode;

public class SubarraySumClosest {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        if (nums == null) {
            return new int[0];
        }
        int ans = Integer.MAX_VALUE;
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    array[0] = i;
                    array[1] = j;
                    return array;
                }
                if (Math.abs(sum) < ans) {
                    ans = Math.abs(sum);
                    array[0] = i;
                    array[1] = j;
                }
            }
        }
        return array;
    }
}
