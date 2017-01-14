package lintcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
//	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
//        // write your code here
//		ArrayList<Integer> sub = new ArrayList<Integer>();
//		ArrayList<Integer> num = new ArrayList<Integer>();		
//		ArrayList<ArrayList<Integer>> subset = new ArrayList<ArrayList<Integer>>();
//		subset.add(new ArrayList<Integer>());
//		for (int i = 0; i < nums.length; i++) {
//			num.add(nums[i]);
//		}
//		for (int i = 0; i < nums.length; i++) {
//			for (int j = i + 1; j < nums.length + 1; j++) {
//				sub = new ArrayList<Integer>();
//				sub.addAll(num.subList(i, j));
//				subset.add(sub);
//			}
//		}
//		return subset;
//    }
//	
	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
	    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<Integer>(), nums, 0);
	    return list;
	}

	private void backtrack(ArrayList<ArrayList<Integer>> list , ArrayList<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<Integer>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
}
