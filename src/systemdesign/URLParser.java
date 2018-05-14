package systemdesign;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class URLParser {
    private static final String HTML_HREF_TAG_PATTERN =  "\\s*(?i)href\\s*=\\s*(\"|')+([^\"'>\\s]*)";
    /**
     * @param content source code
     * @return a list of links
     */
    public List<String> parseUrls(String content) {
        // Write your code here
        List<String> links = new ArrayList<String>();
        Pattern pattern = Pattern.compile(HTML_HREF_TAG_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        String url = null;
        while (matcher.find()) {
            url = matcher.group(2);
            if (url.length() == 0 || url.startsWith("#"))
                continue;
            links.add(url);
        }
        return links;
    }
}