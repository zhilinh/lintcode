package lintcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindLicensePlateNumber {
	public String extractLicensePlateNumber( String text ) {
		String ans = "";
		String test1, test2;
	      
	    // If text is null or less than 6 characters
	    // return an empty string
	    if (text == null || text.length() < 6) {
	        return ans;
	    }
	    
	    // Define three patterns
	    Pattern firstPattern = Pattern.compile("[A-Z]{3}[0-9]{3}");
	    Pattern secondPattern = Pattern.compile("[0-9]{3}[A-Z]{3}");
	    Pattern thirdPattern = Pattern.compile("[0-9][A-Z&&[^IOQ]]{3}[0-9]{3}");
	    Matcher firstMatcher;
	    Matcher secondMatcher;
	    Matcher thirdMatcher;
	    
	    // Iterate the text string to find a match
	    for (int i = 0; i < text.length() - 5; i++) {
	        test1 = text.substring(i, i + 6);
	        firstMatcher = firstPattern.matcher(test1);
	        secondMatcher = secondPattern.matcher(test1);
	        if (firstMatcher.matches() || secondMatcher.matches()) {
	            ans = test1;
	            break;
	        }
	        
	        if (i + 7 <= text.length()) {
	            test2 = text.substring(i, i + 7);
	            thirdMatcher = thirdPattern.matcher(test2);
	            if (thirdMatcher.matches()) {
	                ans = test2;
	                break;
	            }
	        }
	    }
	    return ans;
	}
}
