package com.maryna.photographer.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.maryna.photographer.model.PhotoSession;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface PhotoSessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPhotoSessions(List<PhotoSession> photoSessions);

    @Query("SELECT * FROM PhotoSession")
    Single<List<PhotoSession>> getAllPhotoSessions();

    @Query("SELECT * FROM PhotoSession where sessionId = :id")
    Single<PhotoSession> getPhotoSessionById(int id);
}
