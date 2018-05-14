package systemdesign;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MiniTwitter {
	
	public static class Tweet {
		public int id;
		public int user_id;
		public String text;
		public static Tweet create(int user_id, String tweet_text) {
			// This will create a new tweet object,
			// and auto fill id
			Tweet tweet =  new Tweet();
			tweet.user_id = user_id;
			tweet.text = tweet_text;
			return tweet;
		}
	}
	
    Map<Integer, Set<Integer>> map;
    LinkedList<Tweet> ls;
    public MiniTwitter() {
        // do intialization if necessary
        map = new HashMap<Integer, Set<Integer>>();
        ls = new LinkedList<Tweet>();
    }

    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        // write your code here
    	Tweet post = Tweet.create(user_id, tweet_text);
        ls.addFirst(post);
        return post;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        // write your code here
        List<Tweet> res = new ArrayList<>();
        if(map.get(user_id) != null){
            for(Tweet t: ls){
                if(t.user_id == user_id || map.get(user_id).contains(t.user_id)){
                    res.add(t);
                }
                if(res.size() == 10){
                    break;
                }
            }
        }else{
            for(Tweet t: ls){
                if(t.user_id == user_id){
                    res.add(t);
                }
                if(res.size() == 10){
                    break;
                }
            }
        }
        return res;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        // write your code here
        List<Tweet> res = new ArrayList<>();
        for(Tweet t: ls){
            if(t.user_id == user_id){
                    res.add(t);
            }
            if(res.size() == 10){
                break;
            }
        }
        return res;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        // write your code here
        if(!map.containsKey(from_user_id)){
            map.put(from_user_id, new HashSet<Integer>());
            map.get(from_user_id).add(to_user_id);
        }else{
            map.get(from_user_id).add(to_user_id);
        }
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
        if(!map.containsKey(from_user_id)){
            return;
        }else{
            if(map.get(from_user_id).contains(to_user_id)){
                map.get(from_user_id).remove(to_user_id);
                if(map.get(from_user_id).size() == 0){
                    map.remove(from_user_id);
                }
            }
        }
    }
}