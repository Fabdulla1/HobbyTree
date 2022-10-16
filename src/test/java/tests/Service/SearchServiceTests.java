package tests.Service;

import Databases.Database;
import Services.AccountService;
import Services.SearchService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import types.Address;
import types.Post;
import types.Profile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchServiceTests {

    private Map<String, String> allUserNames;
    private Map<String, Profile> allProfiles;
    private List<Post> allPosts;

    private Database database;
    private SearchService searchService;

    private String[] usernames = new String[]{"user1","tomato2","potato3"};
    private String[] passcodes = new String[]{"1","2","3"};

    private LocalDateTime date = LocalDateTime.now();
    private LocalDateTime[] dates = new LocalDateTime[6];
    private Address[] addresses = new Address[4];

    private Post user1post1; // 1
    private Post user1post2; // 2
    private Post user1post3; // 3
    private Post user2post1; // 4
    private Post user2post2; // 5
    private Post user3post1; // 6
    private Post user3post2; // 7

    @BeforeEach
    void setUp() {
        allUserNames = new HashMap<>();
        allProfiles = new HashMap<>();
        allPosts = new ArrayList<>();

        for (int i = 0; i < usernames.length; i++) {
            allUserNames.put(usernames[i], passcodes[i]);
        }

        Profile profile1 = new Profile("Ace", "", "" ,null, false);
        Profile profile2 = new Profile("Brick", "", "" ,null, false);
        Profile profile3 = new Profile("Court", "", "" ,null, false);

        addresses[0] = new Address();
        addresses[1] = new Address();
        addresses[2] = new Address();
        addresses[3] = new Address();

        addresses[0].setBuildingNumber("01");
        addresses[1].setBuildingNumber("1");
        addresses[2].setBuildingNumber("2");
        addresses[3].setBuildingNumber("3");

        profile1.setUsername(usernames[0]);
        profile2.setUsername(usernames[1]);
        profile3.setUsername(usernames[2]);

        for (int i = 0; i < dates.length; i++) {
            dates[i] = date.minusDays(10 * i);
        }

        user1post1 = new Post(usernames[0], dates[0], "swimming", "sports", "", addresses[0]);
        user1post2 = new Post(usernames[0], dates[1], "ramen", "foods", "", addresses[0]);
        user1post3 = new Post(usernames[0], dates[2], "Harry Potter", "movies", "", addresses[0]);

        user2post1 = new Post(usernames[1], dates[3], "corn", "foods", "", addresses[1]);
        user2post2 = new Post(usernames[1], dates[4], "BTS", "music", "", addresses[1]);

        user3post1 = new Post(usernames[2], dates[5], "Percy Jackson", "books", "", addresses[2]);
        user3post2 = new Post(usernames[2], dates[2], "mario", "video games", "", addresses[2]);

        profile1.addPost(user1post1);
        profile1.addPost(user1post2);
        profile1.addPost(user1post3);

        profile2.addPost(user2post1);
        profile2.addPost(user2post2);

        profile3.addPost(user3post1);
        profile3.addPost(user3post2);

        allProfiles.put(usernames[0], profile1);
        allProfiles.put(usernames[1], profile2);
        allProfiles.put(usernames[2], profile3);

        profile1.addFriend(profile2);

        allPosts.add(user1post1);
        allPosts.add(user1post2);
        allPosts.add(user1post3);

        allPosts.add(user2post1);
        allPosts.add(user2post2);

        allPosts.add(user3post1);
        allPosts.add(user3post2);

        database = new Database(allUserNames, allProfiles, allPosts);
        searchService = new SearchService(database);
    }

    @Test
    public void getPostByUsername() {

        List<Post> posts = searchService.getPostByUsername(usernames[1]);

        assertEquals(2, posts.size());
        assertEquals(user2post1, posts.get(0));
    }

    @Test
    public void getPostByAllFriends() {

        List<Post> posts = searchService.getPostsByAllFriends(usernames[0]);

        assertEquals(2, posts.size());
        assertEquals(user2post1, posts.get(0));
        assertEquals(user2post2, posts.get(1));
    }

    @Test
    public void getPostByInterests() {

        List<Post> posts = searchService.getByOnlyInterest("foods");

        assertEquals(2, posts.size());
        assertEquals(user1post2, posts.get(0));
    }


    @Test
    public void getAllPostsByDate() {

        List<Post> posts = searchService.getAllPostsByDate();

        assertEquals(7, posts.size());
        assertEquals(user3post1, posts.get(0));

        assertEquals(user2post2, posts.get(1));
        assertEquals(user2post1, posts.get(2));

        assertEquals(user1post3, posts.get(3));
        assertEquals(user3post2, posts.get(4));
        assertEquals(user1post2, posts.get(5));
        assertEquals(user1post1, posts.get(6));
    }

    @Test
    public void getAllPosts() {
        List<Post> posts = searchService.getAllPosts();

        assertEquals(7, posts.size());
        assertEquals(allPosts, posts);
    }
}
