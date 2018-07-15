package minitwitter;

public class ShowData implements Visitor {
    
    public int getUsers(adminUI admin) {
        return admin.getUsers();
    }
    
    public int getGroups(adminUI admin) {
        return admin.getGroups();
    }
    
    public int getMessages(adminUI admin) {
        return admin.getMessages();
    }
    
    public int getPositive(adminUI admin) {
        return admin.getPercentage();
    }
}
