package systemdesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FriendshipService {
	Map<Integer, Set<Integer>> followers;
	Map<Integer, Set<Integer>> followees;
	
    public FriendshipService() {
        // do initialization if necessary
    	followers = new HashMap<Integer, Set<Integer>>();
    	followees = new HashMap<Integer, Set<Integer>>();
    }

    /*
     * @param user_id: An integer
     * @return: all followers and sort by user_id
     */
    public List<Integer> getFollowers(int user_id) {
        // write your code here
    	if (!followers.containsKey(user_id)) {
    		return new ArrayList<Integer>();
    	}
    	List<Integer> f = new ArrayList<Integer>(followers.get(user_id));
    	Collections.sort(f);
    	return f;
    }

    /*
     * @param user_id: An integer
     * @return: all followings and sort by user_id
     */
    public List<Integer> getFollowings(int user_id) {
        // write your code here
    	if (!followees.containsKey(user_id)) {
    		return new ArrayList<Integer>();
    	}
    	List<Integer> f = new ArrayList<Integer>(followees.get(user_id));
    	Collections.sort(f);
    	return f;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int to_user_id, int from_user_id) {
        // write your code here
    	if (!followers.containsKey(to_user_id)) {
    		followers.put(to_user_id, new HashSet<Integer>());
    	}
    	Set<Integer> f = followers.get(to_user_id);
    	f.add(from_user_id);
    	if (!followees.containsKey(from_user_id)) {
    		followees.put(from_user_id, new HashSet<Integer>());
    	}
    	f = followees.get(from_user_id);
    	f.add(to_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int to_user_id, int from_user_id) {
        // write your code here
    	if (!followers.containsKey(to_user_id)) {
    		followers.put(to_user_id, new HashSet<Integer>());
    	}
    	Set<Integer> f = followers.get(to_user_id);
    	f.remove(from_user_id);
    	if (!followees.containsKey(from_user_id)) {
    		followees.put(from_user_id, new HashSet<Integer>());
    	}
    	f = followees.get(from_user_id);
    	f.remove(to_user_id);
    }
}
