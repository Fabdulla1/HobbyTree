import Databases.Database;
import Services.AccountService;
import Services.PostService;
import Services.SearchService;
import types.Post;
import types.Profile;

import javax.security.auth.login.AccountException;
import java.util.List;
import java.util.Map;

public class App {
    private static Database database;

    public App() {}

    public void setUpDatabase() {

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

}
