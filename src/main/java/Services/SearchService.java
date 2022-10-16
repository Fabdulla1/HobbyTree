package Services;

import Databases.Database;
import types.Post;
import types.Profile;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private Database database;

    public SearchService(Database database) {
        this.database = database;
    }

    public List<Post> getAllPosts(){
        return database.getAllPosts();
    }

    public List<Post> getPostsByFriends(String username){
        List<Post> posts = new ArrayList<>();
        for (Profile friendProfile : database.getAllProfiles().get(username).get_friendList()) {
            posts.addAll(friendProfile.get_posts());
        }
        return posts;
    }

    // come back
    public List<Post> getPostByDate(){
        return database.getAllPosts();
    }

    public List<Post> getPostByUsername(String username){
        return database.getAllProfiles().get(username).get_posts();
    }

    // The API needs to generate words similiar to the words parameter
    public List<Post> getPostByWordSearch(String words) {
        return null;
    }

    public List<Post> getByOnlyInterest(String interest) {
        List<Post> posts = new ArrayList<>();
        for (Post post : database.getAllPosts()) {
            if (post.getInterest().equals(interest)) {
                posts.add(post);
            }
        }
        return posts;
    }

}
