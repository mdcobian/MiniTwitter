package minitwitter;

import java.awt.List;

public class User implements Observer {
    private String id;
    private long lastUpdate;
    
    public User(String identity) {
        id = identity;
    }
    
    public void attach() {
        
    }
    
    public void tweet() {
        lastUpdate = System.currentTimeMillis();
    }
    
    public void update() {
        
    }
    
    public String getID(){
        return id;
    }
    
    public long getLastUpdate() {
        return lastUpdate;
    }
    
    public List getFollowers() {
        return null;
    }
    
    public List getFollowing(){
        return null;
    }
    
    public List getFeed() {
        return null;
    }
}
