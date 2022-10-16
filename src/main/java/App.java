import Databases.Database;
import Services.AccountService;
import Services.PostService;
import Services.SearchService;
import types.Address;
import types.Post;
import types.Profile;

import javax.security.auth.login.AccountException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    private static Database database;

    private App() {}

    public static void setUpDatabase() {
        Profile Bob = new Profile("bob123", "1/2/2003", "9161284767",
                new Address("123", "Main Street", "14", "Berkeley", "CA",
                        "USA", "94720"), false);

        Profile Dan = new Profile("dan123", "1/3/2003", "9096234567",
                new Address("124", "Elm Street", "12", "San Francisco", "CA",
                        "USA", "94728"), false);

        Profile Niel = new Profile("niel123", "1/4/2003", "9161234836",
                new Address("125", "Oak Street", "15", "Sacramento", "CA",
                        "USA", "99620"), true);

        Profile John = new Profile("john123", "3/2/2003", "9161937567",
                new Address("126", "Telegraph Street", "16", "Salt Lake City", "UT",
                        "USA", "96520"), true);

        Profile Allison = new Profile("allison123", "5/2/2003", "9193752567",
                new Address("127", "Durant Street", "17", "Berkeley", "CA",
                        "USA", "94721"), false);

        Map<String, String> usernames = new HashMap<>();
        String[] usernameList = new String[]{"bob123", "dan123", "niel123", "john123", "allison123"};
        String[] passwords = new String[]{"as;dlk", "weodkk", "icjdh", "weoifj", "eidkdj"};
        Profile[] profiles = new Profile[]{Bob, Dan, Niel, John, Allison};
        for (int i = 0; i < 5; i += 1) {
            usernames.put(usernameList[i], passwords[i]);
        }

        Map<String, Profile> profileMap = new HashMap<>();
        for (int i = 0; i < 5; i += 1) {
            profileMap.put(usernameList[i], profiles[i]);
            profiles[i].setUsername(usernameList[i]);
            profiles[i].setPasscode(passwords[i]);
        }

        // Dates
        LocalDateTime date = LocalDateTime.now();
        LocalDateTime[] dates = new LocalDateTime[6];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = date.minusDays(10 * i);
        }

        Post bobPost1 = new Post(Bob.getUsername(), dates[0], "Harry Potter", "Book",
                "I read Harry Potter for the first time", Bob.get_address());
        Post bobPost2 = new Post(Bob.getUsername(), dates[1], "pizza", "Foods",
                "I ate some pizza!", Bob.get_address());

        Post danPost1 = new Post(Dan.getUsername(), dates[2], "Harry Potter", "Book",
                "I read Harry Potter for the second time!", Dan.get_address());

        Post nielPost1 = new Post(Niel.getUsername(), dates[3], "Swimming", "Sports",
                "I swam in my pool", Niel.get_address());

        Post johnPost1 = new Post(John.getUsername(), dates[4], "Hiking", "Sports",
                "I read Harry Potter for the first time", John.get_address());

        Post allisonPost1 = new Post(Allison.getUsername(), dates[5], "BTS", "Music",
                "I love BTS", Allison.get_address());

        List<Post> posts = new ArrayList<>();
        posts.add(bobPost1);
        posts.add(bobPost2);
        posts.add(danPost1);
        posts.add(nielPost1);
        posts.add(johnPost1);
        posts.add(allisonPost1);

        database = new Database(usernames, profileMap, posts);
    }

    public static Database getDatabase() {
        return database;
    }

    public static SearchService getSearchService() {
        return new SearchService(getDatabase());
    }

    public static PostService getPostService() {
        return new PostService(getDatabase());
    }

    public static AccountService getAccountService() {
        return new AccountService(getDatabase());
    }

    public static HobbyClient getHobbyClient(){
        return new HobbyClient(getAccountService(), getPostService(), getSearchService());
    }
}
