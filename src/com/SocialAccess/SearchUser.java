package com.SocialAccess;

import java.util.Iterator;
import twitter4j.ResponseList;
import twitter4j.Twitter;
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
    
    public static void main(String[] args) {
        SearchUser su=new SearchUser();
        su.searchOnTwitter();
    }
    
}
