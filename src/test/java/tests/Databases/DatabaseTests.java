package tests.Databases;

import Databases.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.Post;
import tests.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseTests {
    private Map<String, String> allUserNames;
    private Map<String, Profile> allProfiles;
    private List<Post> allPosts;

    private Database database;

    private String username = "FuzzyPenguinSlippers";
    private String passcode = "HelloWorld123";

    @BeforeEach
    void setUp() {
        allProfiles = new HashMap<>();
        allPosts = new ArrayList<>();
        allUserNames = new HashMap<>();

        allUserNames.put(username, passcode);
        database = new Database(allUserNames, allProfiles, allPosts);
    }

    @Test
    public void userExists_returnsTrue() {
        Boolean exists = database.userExists(username);

        assertTrue(exists);
    }

    @Test
    public void checkPasscode_returnsTrue() {
        Boolean correct = database.checkPasscode(username, passcode);

        assertTrue(correct);
    }
}
