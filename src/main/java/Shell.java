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
        App.setUpDatabase();
        Shell shell = new Shell(App.getAccountService(), App.getPostService(), App.getSearchService());

        System.out.println("~~ Latest Posts: ~~ \n");
        List<Post> posts = shell.searchService.getAllPosts();
        for (Post post: posts) {
            System.out.println(post.styledPost());
        }

        shell.accountService.CreateUser("fuzzyPenguinSlipplers", "helloWorld",
                new Profile("Jim Carry", "10-2-2000", "234-2132-2321", null, false));

        shell.accountService.addFriend("dan123", "bob123");

        List<Post> friendsPosts = shell.searchService.getPostsByAllFriends("dan123");
        System.out.println("~~ Bob123: ~~ \n");
        for (Post post: friendsPosts) {
            System.out.println(post.styledPost());
        }




    }
}