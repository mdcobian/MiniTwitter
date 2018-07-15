package minitwitter;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Set;
import javax.swing.*;
import javax.swing.tree.*;

public class Action implements ActionListener {
    private adminUI admin;
    private UserViewer userViewer;
    private ShowData visitor = new ShowData();
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command == "ADD_USER") {
            String user = admin.getUserID().getText();
            JTree tree = admin.getTree();
            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(user);
            model.insertNodeInto(child, root, root.getChildCount());
            tree.scrollPathToVisible(new TreePath(child.getPath()));
            admin.incrementUsers();
            admin.update();
        }
        else if(command == "ADD_GROUP") {
            String group = admin.getGroupID().getText();
            JTree tree = admin.getTree();
            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(group);
            model.insertNodeInto(child, root, root.getChildCount());
            tree.scrollPathToVisible(new TreePath(child.getPath()));
            admin.incrementGroups();
            admin.update();
        }
        else if(command == "USER_VIEW") {
            Hashtable profiles = admin.getProfiles();
            JTree tree = admin.getTree();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
            String name = (String)node.getUserObject();
            if(profiles.containsKey(name)) {
                UserViewer profileViewer = (UserViewer)profiles.get(name);
                profileViewer.show();
            }
            else {
                profiles.put(name, new UserViewer(name));
            }
        }
        else if(command == "USER_TOTAL") {
            int total = visitor.getUsers(admin);
            JFrame frame = new JFrame("Show User Total");
            JLabel users = new JLabel("Total Users:" + total);
            frame.add(users);
            frame.pack();
            frame.setVisible(true);
        }
        else if(command == "GROUP_TOTAL") {
            int total = visitor.getGroups(admin);
            JFrame frame = new JFrame("Show Group Total");
            JLabel groups = new JLabel("Total Groups:" + total);
            frame.add(groups);
            frame.pack();
            frame.setVisible(true);
        }
        else if(command == "MESSAGE_TOTAL") {
            int total = visitor.getMessages(admin);
            JFrame frame = new JFrame("Show Group Total");
            JLabel messages = new JLabel("Total Messages:" + total);
            frame.add(messages);
            frame.pack();
            frame.setVisible(true);
        }
        else if(command == "POSITIVE") {
            int total = visitor.getPositive(admin);
            JFrame frame = new JFrame("Show Group Total");
            JLabel positives = new JLabel("Total Positives:" + total + "%");
            frame.add(positives);
            frame.pack();
            frame.setVisible(true);
        }
        else if(command == "FOLLOW_USER") {
            String user = userViewer.getUserID().getText();
            userViewer.add(user);
        }
        else if(command == "TWEET") {
            
        }
    }
    
    public void setAdmin(adminUI source) {
        admin = source;
    }
    
    public void setUserViewer(UserViewer source) {
        userViewer = source;
    }
}
