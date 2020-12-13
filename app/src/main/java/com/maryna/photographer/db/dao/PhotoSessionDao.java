package com.maryna.photographer.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.maryna.photographer.model.PhotoSession;

import java.util.List;

@Dao
public interface PhotoSessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPhotoSessions(List<PhotoSession> photoSessions);

    @Query("SELECT * FROM PhotoSession")
    List<PhotoSession> getAllPhotoSessions();

    @Query("SELECT * FROM PhotoSession where title")
    PhotoSession getPhotoSessionByTitle();
}
