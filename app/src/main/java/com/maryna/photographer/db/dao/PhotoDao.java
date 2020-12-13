package com.maryna.photographer.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.maryna.photographer.model.Photo;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPhotos(List<Photo> photos);

    @Query("SELECT * FROM Photo where sessionType = :sessionType")
    Single<List<Photo>> getPhotosBySession(int sessionType);
}
