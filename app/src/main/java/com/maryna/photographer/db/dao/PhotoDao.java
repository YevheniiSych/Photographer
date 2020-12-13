package com.maryna.photographer.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.maryna.photographer.model.Photo;

import java.util.List;

@Dao
public interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPhotos(List<Photo> photos);

    @Query("SELECT * FROM Photo where sessionType = :sessionType")
    List<Photo> getPhotosBySession(int sessionType);

    @Query("SELECT * FROM Photo where sessionType = :sessionType AND isHeader = 'true'")
    Photo getHeaderPhotoBySession(int sessionType);
}
