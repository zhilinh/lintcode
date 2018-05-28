package googleoa;

import java.util.*;

public class LatestKSlots {
	
	public int solution(int[] P, int K) {
        // write your code in Java SE 8
		TreeSet<Integer> slots = new TreeSet<Integer>();
		int day = 0, latest = -1;
		for (int flower : P) {
			day++;
			slots.add(flower);
			Iterator<Integer> fs = slots.iterator();
			
			int first = fs.next();
			int last = first;
			while (fs.hasNext()) {
				int f = (int) fs.next();
				if (f - last == 1) {
					last = f;
				} else {
					if (last - first + 1 == K) {
						latest = day;
						break;
					}
					last = f;
					first = f;
				}
			}
			if (last - first + 1 == K) {
				latest = day;
			}
		}
		return latest;
    }
}
