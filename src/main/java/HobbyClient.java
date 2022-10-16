import Databases.Database;
import Services.AccountService;
import Services.PostService;
import Services.SearchService;
import types.Address;
import types.Post;
import types.PostsComparator;
import types.Profile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HobbyClient {
    private static AccountService accountService;
    private static PostService postService;
    private static SearchService searchService;

    public HobbyClient(AccountService accountService, PostService postService, SearchService searchService) {
        this.accountService = accountService;
        this.postService = postService;
        this.searchService = searchService;
    }

    public Profile createProfile(String name, String birthday, String number, Address address, boolean status) {
        return new Profile(name, birthday, number, address, status);
    }

    public void addFriend(String username, String friendName) {
        accountService.addFriend(username, friendName);
    }

    public void CreateUser(String user, String passcode, Profile profile) {
        accountService.CreateUser(user, passcode, profile);
    }

    public void logIn(String username, String passcode) {
        accountService.logIn(username, passcode);
    }

    public void logOut() {
        accountService.logOut();
    }

    public boolean getAccess() {
        return accountService.getAccess();
    }

    public Post createPost(String username, LocalDateTime date, String title, String interest, String description, Address address)  {
        return new Post(username, date, title, interest, description, address);
    }

    // update
    public boolean addpost(Post post) {
        return postService.addpost(post);
    }
    public boolean removePost(Post post) {
        return postService.removePost(post);
    }

    // Posts
    public List<Post> getAllPosts(){
        return searchService.getAllPosts();
    }

    public List<Post> getPostsByAllFriends(String username){
        return searchService.getPostsByAllFriends(username);
    }

    public List<Post> getPostsByFriends(List<String> usernames){
        return searchService.getPostsByFriends(usernames);
    }

    public List<Post> getAllPostsByDate(){
        return searchService.getAllPostsByDate();
    }

    public List<Post> getPostByUsername(String username){
        return searchService.getPostByUsername(username);
    }

    public List<Post> getByOnlyInterest(String interest) {
        return searchService.getByOnlyInterest(interest);
    }

}
