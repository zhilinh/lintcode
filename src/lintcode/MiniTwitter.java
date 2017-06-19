//package lintcode;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Definition of Tweet:
// * public class Tweet {
// *     public int id;
// *     public int user_id;
// *     public String text;
// *     public static Tweet create(int user_id, String tweet_text) {
// *         // This will create a new tweet object,
// *         // and auto fill id
// *     }
// * }
// */
//public class MiniTwitter {
//    
//    private Map<Integer, List<Tweet>> user_tweet;
//    private Map<String, List<String>> followers;
//    private int order;
//
//    public MiniTwitter() {
//        // initialize your data structure here.
//        user_tweet = new HashMap<Integer, List<Tweet>>();
//        followers = new HashMap<String, List<String>>();
//        order = 0;
//    }
//
//    // @param user_id an integer
//    // @param tweet a string
//    // return a tweet
//    public Tweet postTweet(int user_id, String tweet_text) {
//        //  Write your code here
//        if (user_tweet.containsKey(user_id)) {
//            user_tweet.put(Integer.valueOf(user_id), new ArrayList<Tweet>());
//        }        
//    }
//
//    // @param user_id an integer
//    // return a list of 10 new feeds recently
//    // and sort by timeline
//    public List<Tweet> getNewsFeed(int user_id) {
//        // Write your code here
//    }
//        
//    // @param user_id an integer
//    // return a list of 10 new posts recently
//    // and sort by timeline
//    public List<Tweet>  getTimeline(int user_id) {
//        // Write your code here
//    }
//
//    // @param from_user_id an integer
//    // @param to_user_id an integer
//    // from user_id follows to_user_id
//    public void follow(int from_user_id, int to_user_id) {
//        // Write your code here
//    }
//
//    // @param from_user_id an integer
//    // @param to_user_id an integer
//    // from user_id unfollows to_user_id
//    public void unfollow(int from_user_id, int to_user_id) {
//        // Write your code here
//    }
//}