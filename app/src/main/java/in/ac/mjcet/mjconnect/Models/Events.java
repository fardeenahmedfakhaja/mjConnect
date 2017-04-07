package in.ac.mjcet.mjconnect.Models;


import org.parceler.Parcel;

/**
 * Created by KHAJA FARDEEN AHMED on 3/11/2017.
 */
@Parcel
public class Events {
    private String contact;
    private String contactPerson;
    private String date;
    private String desc;
    private String name;
    private String posterURL;
    private String studentBody;
    private String fee;
    private String reward;
    private String location;
    Long votes;
    String keyValue;
    int favourite = 0;
    private Events(){

    }

    public Events(String contact, String contactPerson, String date,
                      String desc, String name,
                      String posterURL, String studentBody,String fee,String reward, String location, Long votes, int favourite) {
        this.contact = contact;
        this.contactPerson = contactPerson;
        this.date = date;
        this.desc = desc;

        this.name = name;
        this.posterURL = posterURL;
        this.studentBody = studentBody;
        this.fee=fee;
        this.reward=reward;
        this.location=location;
        this.votes=votes;
        this.favourite=favourite;

    }


    //getters


    public int getFavourite() {
        return favourite;
    }

    public Long getVotes() {
        return votes;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getFee() {
        return fee;
    }

    public String getReward() {
        return reward;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getDate() {
        return date;
    }

    public String getDesc() {
        return desc;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public String getStudentBody() {
        return studentBody;
    }

    //setters


    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public void setStudentBody(String studentBody) {
        this.studentBody = studentBody;
    }


}

