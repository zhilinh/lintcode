package lintcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	/**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> ans = new ArrayList<>();

        intervals.sort(Comparator.comparing(i -> i.start));  //lambda

        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                ans.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end); // Modify the element already in list
            }
        }
        return ans;
    }
}
