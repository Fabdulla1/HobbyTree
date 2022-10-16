import Services.AccountService;
import Services.PostService;
import Services.SearchService;
import types.Address;
import types.Post;
import types.Profile;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Shell {

    private static HobbyClient hobbyClient;

    private AccountService accountService;
    private PostService postService;
    private SearchService searchService;

    public Shell(AccountService accountService, PostService postService, SearchService searchService) {
        this.accountService = accountService;
        this.postService = postService;
        this.searchService = searchService;
    }

    public static void main(String[] args) {
        // Set up
        App.setUpDatabase();
        Shell shell = new Shell(App.getAccountService(), App.getPostService(), App.getSearchService());


        // Latest News Page
        System.out.println("\n~~ Latest Post: ALL ~~ \n");
        List<Post> posts = shell.searchService.getAllPosts();
        for (Post post: posts) {
            System.out.println(post.styledPost());
        }

        // Creating a new User
        System.out.println("New User! ");
        shell.accountService.CreateUser("fuzzyPenguinSlipplers", "helloWorld",
                new Profile("Jim Carry", "10-2-2000", "234-2132-2321",
                        new Address("4012", "Paint St.", "", "Keego Harobr", "MI",
                                "USA", "48323"),
                        false));
        Profile jim = shell.accountService.getProfile("fuzzyPenguinSlipplers");
        System.out.println(jim.styled() + "\n");


        // Adding friend
        shell.accountService.addFriend("fuzzyPenguinSlipplers", "bob123");

        // Getting Friend's Posts
        Profile bob = shell.accountService.getProfile("bob123");
        System.out.println("added: " + bob.styled() + "\n");
        List<Post> friendsPosts = shell.searchService.getPostsByAllFriends("fuzzyPenguinSlipplers");
        for (Post post: friendsPosts) {
            System.out.println(post.styledPost());
        }

        // Search by Food
        List<Post> foodPosts = shell.searchService.getByOnlyInterest("foods");
        System.out.println(">> foods <<");
        for (Post post: foodPosts) {
            System.out.println(post.styledPost());
        }

    }
}