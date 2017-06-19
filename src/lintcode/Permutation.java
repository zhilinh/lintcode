package lintcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        helper(nums, new ArrayList<Integer>(), ans);        
        return ans;
    }
    
    public void helper(int[] nums, List<Integer> partitions, List<List<Integer>> ans) {
        if (partitions.size() == nums.length) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < partitions.size(); i++) {
                tmp.add(nums[partitions.get(i)]);
            }
            ans.add(tmp);
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (! partitions.contains(i)) {
                    partitions.add(i);
                    helper(nums, partitions, ans);
                    partitions.remove(partitions.size() - 1);
                }
            }
        }
    }
}
