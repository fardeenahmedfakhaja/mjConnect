package in.ac.mjcet.mjconnect.Models;

/**
 * Created by Aleem on 01-Mar-17.
 */

public class User {
    private String id;
    private String name;
    private String profilePictureUrl;
    private String rollNo;
    private Long counter;


    public User(){

    }

    public User(String id, String name, String profilePictureUrl, long counter) {
        this.id = id;
        this.name = name;
        this.profilePictureUrl = profilePictureUrl;
        this.counter = counter;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}
