package com.maryna.photographer.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PhotoSession {
    @PrimaryKey(autoGenerate = true)
    private int sessionId;
    private String title;
    private String photoURL;
    private String description;
    private int type;

    public PhotoSession(String title, String photoURL, String description, int type) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.photoURL = photoURL;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}
