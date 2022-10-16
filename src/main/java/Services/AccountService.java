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

    public void CreateUser(String username, String passcode, Profile profile) {
        try {
            database.addUser(username, passcode, profile);
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
}
