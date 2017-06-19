package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<List<Integer>>();        
        if (num == null || target <= 0) {
            return ans;
        }
        Arrays.sort(num);
        helper(num, target, ans, new ArrayList<Integer>(), 0);        
        return ans;
    }
    
    public void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> partitions, int start) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(partitions));
            return;
        }
        int lastNum = 0;
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            if (candidates[i] == lastNum) {
                continue;
            } else {
                lastNum = candidates[i];
            }
            partitions.add(candidates[i]);
            helper(candidates, target - candidates[i], ans, partitions, i + 1);
            partitions.remove(partitions.size() - 1);
        }
    }
}