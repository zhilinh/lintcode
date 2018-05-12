package lintcode;

import java.util.HashMap;
import java.util.Map;

public class RecommendFriends {
	/**
     * @param friends: people's friends
     * @param user: the user's id
     * @return: the person who most likely to know
     */
    public int recommendFriends(int[][] friends, int user) {
        // Write your code here
    	int maxCount = 0;
    	int match = -1;
    	Map<Integer, Integer> fb = new HashMap<Integer, Integer>();
    	fb.put(user, 1);
    	for (int i = 0; i < friends[user].length; i++) {
    		fb.put(friends[user][i], 1);
    	}
    	for (int i = 0; i < friends.length; i++) {
    		if (!fb.containsKey(i)) {
    			int count = 0;
    			for (int j = 0; j < friends[i].length; j++) {
    				if (fb.containsKey(friends[i][j])) {
    					count++;
    				}
    			}
    			if (count > maxCount) {
    				maxCount = count;
    				match = i;
    			}
    		}
    	}
    	return match;
    }
}
