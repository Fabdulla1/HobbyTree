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

    public void logIn(String Username, String Passcode) {
        // check if Username and Passcode are correct

        access = true;
    }

    public void logOut(String Username, String Passcode) {
        boolean access = false;
    }
}
