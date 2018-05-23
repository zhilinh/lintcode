package googleoa;

public class ReinsertDashes {
	public String solution(String S, int K) {
        // write your code in Java SE 8
        S = S.toUpperCase();
        String[] groups = S.split("-");
        StringBuilder all = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int firstGroup, num;
        
        for (String i : groups) {
            all.append(i);
        }
        firstGroup = all.length() % K;
        num = all.length() / K;
        if (firstGroup != 0) {
            ans.append(all.substring(0, firstGroup));
            ans.append('-');
        }
        for (int i = 0; i < num; i++) {
            ans.append(all.substring(firstGroup + i * K, firstGroup + (i + 1) * K));
            if (i != num - 1) {
                ans.append('-');
            }
        }
        return ans.toString();
    }
}
