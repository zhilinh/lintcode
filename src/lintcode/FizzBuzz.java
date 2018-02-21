package lintcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	/*
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        // write your code here
    	List<String> results = new ArrayList<String>();
    	for (int i = 0; i < n; i++) {
    		if (i % 3 == 0 && i % 5 == 0) {
                results.add("fizz buzz");
            } else if (i % 3 == 0) {
                results.add("fizz");
            } else if (i % 5 == 0) {
                results.add("buzz");
            } else  {
                results.add(i + "");
            }
    	}
    	return results;
    }
}
