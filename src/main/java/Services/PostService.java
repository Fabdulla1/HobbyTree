package Services;

import Databases.Database;
import types.Address;
import types.Post;

import java.time.LocalDateTime;

public class PostService {

    private Database database;

    public PostService(Database database) {
        this.database = database;
    }

    public Post createPost(String username, LocalDateTime date, String title, String interest, String description, Address address)  {
        return new Post(username, date, title, interest, description, address);
    }

    public boolean addpost(Post post)  {
        return database.addPost(post);
    }

    public boolean removePost(Post post) {
        return database.removePost(post);
    }
}
