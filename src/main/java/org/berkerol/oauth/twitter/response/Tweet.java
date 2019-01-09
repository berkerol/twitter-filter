package org.berkerol.oauth.twitter.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Tweet {

    @SerializedName("id_str")
    private String id;

    private String text;

    @SerializedName("created_at")
    private Date creationDate;

    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
