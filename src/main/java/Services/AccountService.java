package Services;

import Databases.Database;

public class AccountService {

    private Database database;
    private boolean access;

    public AccountService(Database database) {
        this.database = database;
        this.access = false;
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
