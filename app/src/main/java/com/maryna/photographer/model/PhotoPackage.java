package com.maryna.photographer.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PhotoPackage {
    @PrimaryKey(autoGenerate = true)
    private int packageId;
    private String name;
    private String description;
    private int timeMin;
    private int photoCount;
    private int price;

    public PhotoPackage(String name, String description, int timeMin, int photoCount, int price) {
        this.name = name;
        this.description = description;
        this.timeMin = timeMin;
        this.photoCount = photoCount;
        this.price = price;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeMin() {
        return timeMin;
    }

    public void setTimeMin(int timeMin) {
        this.timeMin = timeMin;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
