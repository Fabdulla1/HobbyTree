package tests.Service;

import Databases.Database;
import Services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import types.Post;
import types.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AccountServiceTests {
    private Map<String, String> allUserNames;
    private Map<String, Profile> allProfiles;
    private List<Post> allPosts;

    private Database database;
    private AccountService acctService;

    private String username = "FuzzyPenguinSlippers";
    private String passcode = "HelloWorld123";


    @BeforeEach
    void setUp() {
        allProfiles = new HashMap<>();
        allPosts = new ArrayList<>();
        allUserNames = new HashMap<>();

        allUserNames.put(username, passcode);
        database = new Database(allUserNames, allProfiles, allPosts);
        acctService = new AccountService(database);
    }

    @Test
    public void logIn_makesAccessTrue() {
        acctService.logIn(username, passcode);
        Boolean access = acctService.getAccess();

        assertTrue(access);
    }

    @Test
    public void logIn_makesAccessFalsebyUsername() {
        acctService.logIn("hello", passcode);
        Boolean access = acctService.getAccess();

        assertFalse(access);
    }

    @Test
    public void logIn_makesAccessFalseByPasscode() {
        acctService.logIn(username, "worlds");
        Boolean access = acctService.getAccess();

        assertFalse(access);
    }


    @Test
    public void logOut_verifyFalse() {
        acctService.logOut();
        Boolean access = acctService.getAccess();

        assertFalse(access);
    }

    @Test
    public void createUser() {

    }
}
