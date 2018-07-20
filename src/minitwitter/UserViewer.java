package minitwitter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class UserViewer {
    private long lastUpdated = 0;
    JFrame frame = new JFrame("User View");
    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    //Panel 1
    JTextField userId = new JTextField("User ID");
    JButton follow = new JButton("Follower User");
    //Panel 2
    JList following = new JList();
    //Panel 3
    JTextField tweet = new JTextField("Tweet Message");
    JButton post = new JButton("Post Tweet");
    //Panel4
    JList feed = new JList();
    //Panel5
    JLabel updateTime = new JLabel("Last updated at: " + String.valueOf(lastUpdated));
    
    private String id;
    private Action action = new Action();
    
    public UserViewer(String identity) {
        id = identity;
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        panel1.setLayout(new FlowLayout());
        panel1.add(userId);
        panel1.add(follow);
        panel2.add(following);
        follow.setActionCommand("FOLLOW_USER");
        follow.addActionListener(action);
        panel3.setLayout(new FlowLayout());
        panel3.add(tweet);
        panel3.add(post);
        post.setActionCommand("TWEET");
        post.addActionListener(action);
        post.addActionListener(action);
        panel4.add(feed);
        panel5.add(updateTime);
        
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
        mainPanel.add(panel5);
        frame.add(mainPanel);
        
        frame.pack();
        frame.setVisible(true);
        
        id = identity;
        action.setUserViewer(this);
    }
    
    public JTextField getUserID() {
        return userId;
    }
    
    public JTextField getTweet() {
        return tweet;
    }
    
    public JList getFollowing() {
        return following;
    }
    public void add(String user) {
        DefaultListModel list = new DefaultListModel();
    }
    
    public JList getFeed() {
        return feed;
    }
    
    public String getID() {
        return id;
    }
    
    public long getLastUpdated() {
        return lastUpdated;
    }
    
    public void setLastUpdated(long update) {
        lastUpdated = update;
        updateTime.setText("Last updated " + lastUpdated);
    }
    
    public void show() {
        frame.pack();
        frame.setVisible(true);
    }
    
    public void refresh() {
        frame.setVisible(false);
        frame.revalidate();
        frame.pack();
        frame.setVisible(true);
    }
}
