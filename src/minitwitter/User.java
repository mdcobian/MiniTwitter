package minitwitter;

import java.awt.List;

public class User implements Observer {
    String id;
    
    public User(String identity) {
        id = identity;
    }
    
    public void attach() {
        
    }
    
    public void tweet() {
        
    }
    
    public void update() {
        
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
