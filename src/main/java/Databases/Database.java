package Databases;

import Exceptions.UsernameAlreadyExistsException;
import types.Post;
import types.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Database {

    private Map<String, String> allUserNames;
    private Map<String, Profile> allProfiles;
    private List<Post> allPosts;

    public Database(Map<String, String> allUserNames, Map<String, Profile> allProfiles, List<Post> allPosts) {
        this.allUserNames = allUserNames;
        this.allProfiles = allProfiles;
        this.allPosts = allPosts;
    }

    public boolean userExists(String username) {
        return allUserNames.containsKey(username);
    }

    public boolean checkPasscode(String username, String passcode) {
        return allUserNames.get(username).equals(passcode);
    }

    public Profile getProfile(String username) {
        return allProfiles.get(username);
    }

    /**
     * Create a new User and Profile
     * @param username user's username
     * @param passcode user's passcode
     * @param profile user's profile
     * @throws UsernameAlreadyExistsException if the username already exists
     */
    public void addUser(String username, String passcode, Profile profile) throws UsernameAlreadyExistsException {
        // We need to check if the username exist already b/c username are unique
        if (allUserNames.containsKey(username) || allProfiles.containsKey(username)) {
            throw new UsernameAlreadyExistsException();
        }
        allUserNames.put(username, passcode);
        allProfiles.put(username, profile);
    }

    public void removeUser(String username, String passcode, Profile profile) {
        allUserNames.remove(username);
        allProfiles.remove(username);
    }

    public boolean addPost(Post post) {
        return allPosts.add(post);
    }

    public boolean removePost(Post post) {
        return allPosts.remove(post);
    }

    public boolean checkUser(String username, String passcode) {
        return allUserNames.containsKey(username) && allUserNames.get(username).equals(passcode);
    }

    public Map<String, String> getAllUserNames() {
        return allUserNames;
    }

    public Map<String, Profile> getAllProfiles() {
        return allProfiles;
    }

    public List<Post> getAllPosts() {
        List<Post> copyPosts = new ArrayList<>();
        copyPosts.addAll(allPosts);
        return copyPosts;
    }
}
