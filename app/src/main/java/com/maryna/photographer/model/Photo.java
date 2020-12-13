package com.maryna.photographer.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Photo {
    @PrimaryKey(autoGenerate = true)
    private int photoId;
    private String photoUrl;
    private int sessionType; // 0 - love story, 1 - family, 2 - сhild, 3 - Individual

    public Photo(String photoUrl, int sessionType) {
        this.photoUrl = photoUrl;
        this.sessionType = sessionType;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getSessionType() {
        return sessionType;
    }

    public void setSessionType(int sessionType) {
        this.sessionType = sessionType;
    }
}
