package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    
    List<Integer> set = new ArrayList<Integer>();
    Map<Integer, Boolean> dict = new HashMap<Integer, Boolean>();

    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here              
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        if (dict.containsKey(value)) {
            return true;
        } else {
            return false;
        }
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
