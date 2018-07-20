package minitwitter;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;

public class adminUI {
    private Hashtable profiles = new Hashtable();
    private int users = 0;
    private int groups = 0;
    private int messages = 0;
    private int positives = 0;
    private Set<String> names = new HashSet<String>();
    private boolean valid = true;
    
    private JFrame frame = new JFrame("Admin UI");
    private JPanel mainPanel = new JPanel();
    private JPanel treePanel = new JPanel(); 
    private JPanel panel = new JPanel();
    private DefaultMutableTreeNode top = new DefaultMutableTreeNode("Root");
    private JTree treeViewer = new JTree(top);
    private JTextField userId = new JTextField("User ID");
    private JButton addUser = new JButton("Add User");
    private JTextField groupId = new JTextField("Group ID");
    private JButton addGroup = new JButton("Add Group");
    private JButton userView = new JButton("Open User View");
    private JButton userTotal = new JButton("Show User Total");
    private JButton groupTotal = new JButton("Show Group Total");
    private JButton messageTotal = new JButton("Show Messages Total");
    private JButton positive = new JButton("Show Positive Percentage");
    
    private JButton verify = new JButton("Verify IDs");
    private JButton lastUpdated = new JButton("Last Updated");
    
    Action action = new Action();
    
    public adminUI() {
        action.setAdmin(this);
        mainPanel.setLayout(new FlowLayout());
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        treePanel.setLayout(new BorderLayout());
        treePanel.add(treeViewer);
        panel.add(userId);
        panel.add(addUser);
        addUser.setActionCommand("ADD_USER");
        addUser.addActionListener(action);
        panel.add(groupId);
        panel.add(addGroup);
        addGroup.setActionCommand("ADD_GROUP");
        addGroup.addActionListener(action);
        panel.add(userView);
        userView.setActionCommand("USER_VIEW");
        userView.addActionListener(action);
        panel.add(userTotal);
        userTotal.setActionCommand("USER_TOTAL");
        userTotal.addActionListener(action);
        panel.add(groupTotal);
        groupTotal.setActionCommand("GROUP_TOTAL");
        groupTotal.addActionListener(action);
        panel.add(messageTotal);
        messageTotal.setActionCommand("MESSAGE_TOTAL");
        messageTotal.addActionListener(action);
        panel.add(positive);
        positive.setActionCommand("POSITIVE");
        positive.addActionListener(action);
        panel.add(verify);
        verify.setActionCommand("VERIFY");
        verify.addActionListener(action);
        panel.add(lastUpdated);
        lastUpdated.setActionCommand("LAST_UPDATED");
        lastUpdated.addActionListener(action);
        mainPanel.add(treePanel);
        mainPanel.add(panel);
        frame.add(mainPanel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    public boolean verifyTree() {
        return valid;
    }
    
    public void addName(String name) {
        names.add(name);
        if(names.contains(name)) {
            valid = false;
        }
    }
    
    public void incrementUsers() {
        users++;
    }
    
    public void incrementGroups() {
        groups++;
    }
    
    public JTree getTree() {
        return treeViewer;
    }
    
    public int getUsers() {
        return users;
    }
    
    public int getGroups() {
        return groups;
    }
    
    public int getMessages() {
        return messages;
    }
    
    public int getPercentage() {
        return (int)(positives*1.0/messages);
    }
    
    public JTextField getUserID() {
        return userId;
    }
    
    public JTextField getGroupID() {
        return groupId;
    }
    
    public Hashtable getProfiles() {
        return profiles;
    }
    
    public void setValid(boolean validity) {
        valid = validity;
    }
    
    public void update() {
        frame.pack();
        frame.revalidate();
        frame.pack();
    }
}
