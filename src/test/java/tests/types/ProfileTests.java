package tests.types;

import org.junit.jupiter.api.Test;
import types.Address;
import types.Post;
import types.Profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTests {

    private Address address = new Address("123", "Paint St.", "", "Berkeley",
                        "CA", "USA", "99342");
    // private Address address2 = new Address(buildingNumber, streetName, aptNumber, city, state, country, zipCode);
    private Profile profile1 = new Profile("Andy", "", "", address, true);
    private Profile profile2 = new Profile("Wesley", "", "", address, true);
    private Profile profile3 = new Profile("Farhan", "", "", address, true);

    private Post post = null;

    @Test
    public void addFriend_successfullyAdded() {
        profile1.addFriend(profile2);

        assertEquals(1, profile1.get_friendList().size());
    }

    @Test
    public void removeFriend_successfullyRemove() {
        profile1.addFriend(profile2);
        profile1.removeFriend(profile2);

        assertEquals(0, profile1.get_friendList().size());
    }

    @Test
    public void addPost_successfullyAdded() {
        profile1.addPost(post);

        assertEquals(1, profile1.get_posts().size());
    }

    @Test
    public void removePost_successfullyRemove() {
        profile1.addPost(post);
        profile1.removePost(post);

        assertEquals(0, profile1.get_posts().size());
    }

    @Test
    public void addInterest_successfullyAdded() {
        profile1.addInterests("Swimming");

        assertEquals(1, profile1.get_interests().size());
        assertTrue(profile1.get_interests().contains("Swimming"));
    }

    @Test
    public void removeInterest_successfullyRemove() {
        profile1.addInterests("Swimming");
        profile1.removeInterests("Swimming");

        assertEquals(0, profile1.get_interests().size());
    }

}
