package minitwitter;

import java.awt.List;

public interface Observer {
    List followers = new List();
    List following = new List();
    List feed = new List();
    
    void attach();
    void tweet();
    void update();
    
    List getFollowers();
    List getFollowing();
    List getFeed();
}
