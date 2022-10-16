package types;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTests {

    private String username = "fuzzyPenguinSlippers";
    private LocalDateTime date = LocalDateTime.now();
    private String title = "Movie";
    private String interest = "Harry Potter";
    private String description = "I went to see Harry Potter for the first time!";
    private Address address = new Address("2274", "Shattuck Ave.", "",
            "Berkeley", "CA", "USA", "94704");


    @Test
    public void createPost() {
        Post post = new Post(username, date, title, interest, description, address);

        assertEquals(username, post.getUsername(), "Username is wrong");
        assertEquals(date, post.getDate(), "date is wrong" );
        assertEquals(title, post.getTitle(), "title is wrong");
        assertEquals(interest, post.getInterest(), "interest is wrong");
        assertEquals(description, post.getDescription(), "description is wrong");
        assertEquals(address, post.getAddress(), "address is wrong");
    }
}
