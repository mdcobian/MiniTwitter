package minitwitter;

public interface Visitor {
    int getUsers(adminUI admin);
    int getGroups(adminUI admin);
    int getMessages(adminUI admin);
    int getPositive(adminUI admin);
}
