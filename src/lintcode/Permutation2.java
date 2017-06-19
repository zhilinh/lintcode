package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Permutation2 {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        Set<List<Integer>> tmp = new HashSet<List<Integer>>();
        helper(nums, new ArrayList<Integer>(), tmp);
        Iterator<List<Integer>> iter = tmp.iterator();
        while (iter.hasNext()) {
            List<Integer> partitions = iter.next();
            ans.add(partitions);
        }
        return ans;
    }
    
    public void helper(int[] nums, List<Integer> partitions, Set<List<Integer>> ans) {
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
