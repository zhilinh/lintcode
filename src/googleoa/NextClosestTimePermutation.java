package googleoa;

import java.util.*;

public class NextClosestTimePermutation {
	char[] ans = new char[4];
	char[] back = new char[4];
	int curr, diff = Integer.MAX_VALUE;
	int minDiff = Integer.MIN_VALUE;
	int midnight = 24 * 60;
    
    public String solution(String S) {
        // write your code in Java SE 8
        List<Character> map = new ArrayList<Character>();
        String[] times = S.split(":");
        int mins = Integer.valueOf(times[0]) * 60;
        int secs = Integer.valueOf(times[1]);
        curr = mins + secs;
        
        for (int i = 0; i < 2; i++) {
            map.add(times[0].charAt(i));
            map.add(times[1].charAt(i));
        }
        
        dfs(0, map, new char[4]);
        if (!map.contains(ans[0])) {
            ans = back;
        }
        if (!map.contains(ans[0])) {
            return S;
        }
        StringBuilder next = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            next.append(ans[i]);
            if (i == 1) {
                next.append(":");
            }
        }
        return next.toString();
    }
    
    public void dfs(int digit, List<Character> dict, char[] comb) {
        if (digit == 4) {
            int mins = (comb[0] - '0') * 600 + (comb[1] - '0') * 60;
            int sec = (comb[2] - '0') * 10 + (comb[3] - '0');
            if (mins > 1380 || sec > 59) {
                return;
            }
            
            int sumTime = mins + sec;
            if (sumTime > curr && sumTime - curr < diff) {
                diff = sumTime - curr;
                ans = Arrays.copyOf(comb, 4);
            }
            if (sumTime < curr && curr - sumTime > minDiff) {
                minDiff = curr - sumTime;
                back = Arrays.copyOf(comb, 4);
            }
            return;
        }
        for (int i = 0; i < dict.size(); i++) {
            comb[digit] = dict.get(i);
            List<Character> tmp = new ArrayList<Character>(dict);
            tmp.remove(i);
            dfs(digit + 1, tmp, comb);
        }
    }

}
