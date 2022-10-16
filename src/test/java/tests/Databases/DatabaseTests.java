package tests.Databases;

import Databases.Database;
import Exceptions.UsernameAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import types.Post;
import types.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTests {
    private Map<String, String> allUserNames;
    private Map<String, Profile> allProfiles;
    private List<Post> allPosts;

    private Database database;

    private String username = "FuzzyPenguinSlippers";
    private String passcode = "HelloWorld123";
    private Profile profile = new Profile("Sam", "01-01-2001", "234-818-3789",
            null, false);

    @BeforeEach
    void setUp() {
        allProfiles = new HashMap<>();
        allPosts = new ArrayList<>();
        allUserNames = new HashMap<>();
        database = new Database(allUserNames, allProfiles, allPosts);
    }

    @Test
    public void userExists_returnsTrue() {
        allUserNames.put(username, passcode);

        Boolean exists = database.userExists(username);

        assertTrue(exists);
    }

    @Test
    public void checkPasscode_returnsTrue() {
        allUserNames.put(username, passcode);

        Boolean correct = database.checkPasscode(username, passcode);

        assertTrue(correct);
    }

    @Test
    public void addUser_addUser() throws UsernameAlreadyExistsException {
        database.addUser(username, passcode, profile);

        assertEquals(1, allProfiles.size());
        assertEquals(1, allUserNames.size());
    }

    @Test
    public void addUser_throwsException() throws UsernameAlreadyExistsException {
        allUserNames.put(username, passcode);

        assertThrows(UsernameAlreadyExistsException.class,
                () -> database.addUser(username, passcode, profile),
                "Username exists - UsernameAlreadyExists!");
    }

    @Test
    public void removeUser_addUser() {
        allUserNames.put(username, passcode);
        allProfiles.put(username, profile);

        database.removeUser(username, passcode, profile);

        assertEquals(0, allProfiles.size());
        assertEquals(0, allUserNames.size());
    }

    @Test
    public void getPosts() {
        database.addPost(null);
        database.addPost(null);
        database.addPost(null);

        List<Post> posts = database.getAllPosts();

        assertEquals(3, posts.size());
    }

}
