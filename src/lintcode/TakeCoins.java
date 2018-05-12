package lintcode;


public class TakeCoins {
	/** DFS
	int[] list;
	int k;
	List<Integer> sums = new ArrayList<Integer>();
	
	private void pick(int left, int right, int step, int sum) {
		if (step == k) {
			sums.add(sum);
			return;
		}
		pick(left + 1, right, step + 1, sum + list[left]);
		pick(left, right - 1, step + 1, sum + list[right]);
	}
	
    public int takeCoins(int[] list, int k) {
        // Write your code here
    	int ans = 0;
    	this.k = k;
    	this.list = list;
    	pick(0, list.length - 1, 0, 0);
    	for (int i = 0; i < sums.size(); i++) {
    		ans = sums.get(i) > ans ? sums.get(i) : ans;
    	}
    	return ans;
    }
    */
	
	/**
     * @param list: The coins
     * @param k: The k
     * @return: The answer
     */
    public int takeCoins(int[] list, int k) {
    	int maxCount = 0;
    	int length = list.length - 1;
    	for (int i = 0; i < k + 1; i++) {
    		int count = 0;
    		for (int j = 0; j < i; j++) {
    			count += list[j];
    		}
    		for (int j = 0; j < k - i; j++) {
    			count += list[length - j];
    		}
    		maxCount = Math.max(count, maxCount);
    	}
    	return maxCount;
    }
}
