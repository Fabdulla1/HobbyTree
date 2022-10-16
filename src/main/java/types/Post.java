package types;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Post{
    private String username;
    private LocalDateTime date;
    private String title;
    private String interest;
    private String description;
    private Address address;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Post(String username, LocalDateTime date, String title, String interest, String description, Address address) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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

    @Override
    public String toString() {
        return "Post{" +
                "username='" + username + '\'' +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", interest='" + interest + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                '}';
    }

    public String styledPost() {
        return String.format("* %s *%n%s%n@%s%n%s%n%s%n%s%n",
                title, interest, username, date.format(formatter),  description, address.styled());
    }
}
