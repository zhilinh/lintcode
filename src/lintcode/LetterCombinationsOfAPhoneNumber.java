package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
	
	Map<Character, char[]> map = new HashMap<Character, char[]>();
	
	/**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
    	List<String> ans = new ArrayList<String>();    	
    	String curr = "";
    	map.put('2', new char[] {'a', 'b', 'c'});
    	map.put('3', new char[] {'d', 'e', 'f'});
    	map.put('4', new char[] {'g', 'h', 'i'});
    	map.put('5', new char[] {'j', 'k', 'l'});
    	map.put('6', new char[] {'m', 'n', 'o'});
    	map.put('7', new char[] {'p', 'q', 'r', 's'});
    	map.put('8', new char[] {'t', 'u', 'v'});
    	map.put('9', new char[] {'w', 'x', 'y', 'z'});
    	dfs(ans, digits, curr);
    	return ans;
    }
    
    private void dfs(List<String> ans, String digits, String curr) {
    	if (digits.equals("")) {
    		if (!curr.equals("")) {
    			ans.add(curr);
    		}
    		return;
    	}
    	
    	char digit = digits.charAt(0);
    	for (char i : map.get(digit)) {
    		dfs(ans, digits.substring(1, digits.length()), curr + i);
    	}
    }
}
