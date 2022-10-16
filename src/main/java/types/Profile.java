package types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Profile {
    private String username;
    private String passcode;
    private String _name;
    private String _birthday;
    private String phoneNumber;
    private Address _address;
    private boolean _status;
    private Set<Profile> _friendList;
    private Set<String> _interests;
    private List<Post> _posts;

    Profile(String name, String birthday, String number, Address address, boolean status) {
        _name = name;
        _birthday = birthday;
        phoneNumber = number;
        _address = address;
        _status = status;
        _friendList = new HashSet<>();
        _interests = new HashSet<>();
        _posts = new ArrayList<>();
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String get_name() {
        return _name;
    }

    public String get_birthday() {
        return _birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address get_address() {
        return _address;
    }

    public boolean is_status() {
        return _status;
    }

    public Set<Profile> get_friendList() {
        return _friendList;
    }

    public Set<String> get_interests() {
        return _interests;
    }

    public List<Post> get_posts() {
        return _posts;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_birthday(String _birthday) {
        this._birthday = _birthday;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void set_address(Address _address) {
        this._address = _address;
    }

    public void set_status(boolean _status) {
        this._status = _status;
    }

    private void addFriend(Profile friend) {
        if (!_friendList.contains(friend)) {
            _friendList.add(friend);
        }
    }

    private void removeFriend(Profile friend) {
        if (_friendList.contains(friend)) {
            _friendList.remove(friend);
        }
    }

    private void addInterests(String interest) {
        _interests.add(interest);
    }

    private void removeInterests(String interest) {
        _interests.remove(interest);
    }

    private void addPost(Post post) {
        if (!_posts.contains(post)) {
            _posts.add(post);
        }
    }

    private void removePost(Post post) {
        if (_posts.contains(post)) {
            _posts.remove(post);
        }
    }


    // + getFriendsFromActions():List<profile>
    // + getFriendsFromAddress():List<profile>

}