package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (candidates == null || target <= 0) {
            return ans;
        }
        Set<Integer> rmdup = new HashSet<Integer>();       
        for (int i = 0; i < candidates.length; i++) {
            rmdup.add(candidates[i]);
        }        
        Integer[] copy = rmdup.toArray(new Integer[rmdup.size()]);
        Arrays.sort(copy);
        helper(copy, target, ans, new ArrayList<Integer>(), 0);
        return ans;
    }
    
    public void helper(Integer[] candidates, int target, List<List<Integer>> ans, List<Integer> partitions, int start) {        
        if (target == 0) {
            ans.add(new ArrayList<Integer>(partitions));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            partitions.add(candidates[i]);
            helper(candidates, target - candidates[i], ans, partitions, i);
            partitions.remove(partitions.size() - 1);
        }
    }
}