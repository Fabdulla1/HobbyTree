package types;

import java.util.Comparator;

public class PostsComparator implements Comparator<Post> {

    @Override
    public int compare(Post post1, Post post2) {
        if (post1.getDate().equals(post2.getDate())) {
            return 0;
        } else if (post1.getDate().isBefore(post2.getDate())) {
            return -1;
        } else {
            return 1;
        }
    }
}
