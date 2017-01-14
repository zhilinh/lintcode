package lintcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsTwo {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
	    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<Integer>(), nums, 0);
	    return list;
	}

	private void backtrack(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<Integer>(tempList));
	    for(int i = start; i < nums.length; i++){
	        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	} 
}
