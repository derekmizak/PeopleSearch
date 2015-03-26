package com.SocialAccess;

import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class SearchUser {
    
    public void searchOnTwitter(){
        int page=1;
        int numberofusers=0;
        try{
        Twitter twitter = new TwitterFactory().getInstance();
       ResponseList<User> users;
               //= twitter.searchUsers("Microsoft", page);
       
       do {
                users = twitter.searchUsers("mizak", page);
                for (User user : users) {
                    if (user.getStatus() != null) {
                        System.out.println("@" + user.getScreenName() + " - " + user.getFollowersCount());
                       numberofusers++;
                       
                    } else {
                        // the user is protected
                        System.out.println("@" + user.getScreenName());
                       
                    }
                }
                page++;
                //System.out.println(page);
            } while (users.size() != 0 && page < 50);
            System.out.println("I'v found " + numberofusers );
       
       
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    
    
    
    public void GetAvailableTrends() {
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            ResponseList<Location> locations;
            locations = twitter.getAvailableTrends();
            System.out.println("Showing available trends");
            for (Location location : locations) {
                System.out.println(location.getName() + " (woeid:" + location.getWoeid() + ")");
            }
            System.out.println("done.");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get trends: " + te.getMessage());
            System.exit(-1);
        }
    }
    
    public static void main(String[] args) {
        SearchUser su=new SearchUser();
        //su.searchOnTwitter();
        su.GetAvailableTrends();
        
    }
    
}
