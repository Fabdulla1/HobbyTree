package Services;

import Databases.Database;
import types.Profile;

public class AccountService {

    private Database database;
    private boolean access;

    public AccountService(Database database) {
        this.database = database;
        this.access = false;
    }

    // Create a method to add a phto from java images

    public void CreateUser(String username, String passcode, Profile profile) {
        try {
            database.addUser(username, passcode, profile);
            profile.setUsername(username);
            profile.setPasscode(passcode);
        } catch (Exception e) {
            System.out.println("Username is Already Taken");
        }
    }

    public void logIn(String username, String passcode) {
        // check if Username and Passcode are correct
        if (database.userExists(username) && database.checkPasscode(username, passcode)) {
            access = true;
        }
    }

    public void logOut() {
        access = false;
    }

    public boolean getAccess() {
        return access;
    }

    public void addFriend(String username, String friendName) {
        Profile self = database.getAllProfiles().get(username);
        Profile friend = database.getAllProfiles().get(friendName);
        self.addFriend(friend);
    }
}
