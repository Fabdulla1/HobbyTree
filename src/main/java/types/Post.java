package types;

import java.util.Objects;

public class Post {
    private String username;
    private String date;
    private String title;
    private String interest;
    private String description;
    private Address address;

    public Post(String username, String date, String title, String interest, String description, Address address) {
        this.username = username;
        this.date = date;
        this.title = title;
        this.interest = interest;
        this.description = description;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return getUsername().equals(post.getUsername()) && getDate().equals(post.getDate()) && getTitle().equals(post.getTitle()) && getInterest().equals(post.getInterest()) && getDescription().equals(post.getDescription()) && getAddress().equals(post.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getDate(), getTitle(), getInterest(), getDescription(), getAddress());
    }


}
