package org.berkerol.oauth.twitter.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {

    @SerializedName("id_str")
    private String id;

    @SerializedName("screen_name")
    private String screenName;

    @SerializedName("created_at")
    private Date creationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        return this.id.equals(((User) object).getId());
    }
}
