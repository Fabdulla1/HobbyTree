package Databases;

import Exceptions.UsernameAlreadyExists;
import types.Post;
import types.Profile;

import java.util.List;
import java.util.Map;

public class Database {

    Map<String, String> allUserNames;
    Map<String, Profile> allProfiles;
    List<Post> allPosts;

    public Database(Map<String, String> allUserNames, Map<String, Profile> allProfiles, List<Post> allPosts) {
        this.allUserNames = allUserNames;
        this.allProfiles = allProfiles;
        this.allPosts = allPosts;
    }

    /**
     * Create a new User and Profile
     * @param username user's username
     * @param passcode user's passcode
     * @param profile user's profile
     * @throws UsernameAlreadyExists if the username already exists
     */
    public void addUser(String username, String passcode, Profile profile) throws UsernameAlreadyExists {
        // We need to check if the username exist already b/c username are unique
        if (allUserNames.containsKey(username) || allProfiles.containsKey(username)) {
            throw new UsernameAlreadyExists();
        }
        allUserNames.put(username, passcode);
        allProfiles.put(username, profile);
    }

    public void removeUser(String username, String passcode, Profile profile) {
        allUserNames.remove(username);
        allProfiles.remove(username);
    }

    public void addPost(Post post) {
        allPosts.add(post);
    }

    public void removePost(Post post) {
        allPosts.remove(post);
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
        return allPosts;
    }
}
